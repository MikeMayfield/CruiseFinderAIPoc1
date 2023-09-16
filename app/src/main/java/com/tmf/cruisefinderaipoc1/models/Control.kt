package com.tmf.cruisefinderaipoc1.models

import android.content.res.Resources.NotFoundException
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinx.serialization.Serializable

@Serializable
data class Control(
    val AlignText: String? = "Left",  //Text alignment: "Left", "Right"
    val BoundValue: String? = null,  //ID of bound value in the data instance
    val Choices: String? = null,  //List of choices for a dropdown list, separated by "|"
    val Control: String,  //Control type: "Text", "Group", etc.
    val Controls: List<Control> = listOf(),  //Optional list of child controls for this control parent
    val DefaultValue: String? = null,  //Default value, if none provided in BoundData
    val Hint: String? = null,  //Hint to display in input box when no value is currently selected
    val ID: String? = null,  //ID of this control, for reference within a collection of Controls by parent control
    val Icon: String? = null,  //Name of icon graphic
    val Label: String = "",  //Label to display in non-collapsing section of control (e.g. SomeLabel: SomeText)
    val OnClick: String? = null,  //ID of click handler to call on button click
    val OnClickArgs: String? = null,  //List of string arguments, formatted as 'argname="value",...'
    val Validate: String? = null,  //Regex to apply to input text control to validate input value
    val SingleLine: Boolean = true,  //Flag: Single line (with ellipse) or multiple lines
    val Text: String = "",  //Dynamic text to display after label. Text can include dynamic formatting functions, such as {FunctionName:args}
) {
    //region Public properties

    var recomposeTrigger = mutableStateOf(0)

    //Value of control, formatted using template, if any. Changing control value causes LiveText to be updated and recompose to be triggered
    var liveValue: String
        get() = _liveValue
        set(value) {
            if (value != _liveValue) {
                _liveValue = value
                var boundDataValue = LiveData.boundData.dataValue(controlIdLc)
                if (boundDataValue == null) {
                    boundDataValue = LiveData.boundData.addValue(controlIdLc)
                }
                boundDataValue.Value = value
                LiveData.saveChanges()  //Serialize changed bound value to repository  //TODO Could this be optimized to only save after a group of changes are made?

                triggerRecompose()
            }
        }
    private var _liveValue  = DefaultValue ?: ""

    //Text field formatted using template
    private val liveText: String
        get() = if (Text.isNotEmpty()) stringFromTemplate(Text, this) else ""

    //Determine if the value is valid, based on the Validate regex. Control is valid if it matches its own validation and all its children (if any) also are valid
    val isValid : Boolean
        get() {
            var controlIsValid = regex?.matches(liveValue) ?: true
            if (controlIsValid && !Controls.isNullOrEmpty()) {
                for (control in Controls) {
                    if (!control.isValid) {
                        controlIsValid = false
                        break
                    }
                }
            }
            return controlIsValid
        }

    val annotatedLabel: AnnotatedString
        get() {
            val localLiveText = liveText
            return AnnotatedString(
                "${stringFromTemplate(Label, this)}${if (localLiveText.isNotEmpty()) ": $localLiveText" else ""}",
                spanStyles = listOf(
                    AnnotatedString.Range(SpanStyle(fontWeight = FontWeight.Bold), 0, Label.length)
                )
            )
        }

    val choices by lazy {
        Choices?.split('|') ?: listOf<String>()
    }

    //endregion

    //region Public methods

    fun init() {
        val boundDataForControl = LiveData.boundData.dataValue(controlIdLc)
        if (boundDataForControl != null) {
            val initialLiveValue = boundDataForControl.Value ?: DefaultValue ?: ""
            if (initialLiveValue != liveValue) {
                liveValue = initialLiveValue  //Note: Also updates LiveText
            }
        }
    }

    //endregion

    //region Private properties

    val controlIdLc: String by lazy {
        ID?.lowercase() ?: BoundValue?.lowercase() ?: throw NotFoundException("No control ID for $Control control with label: $Label, text: $Text")
    }

    private val regex: Regex? by lazy {
        if (Validate != null) Regex(Validate) else null
    }

    private val labelWithText
        get() = stringFromTemplate(Label + if (liveText.isNotEmpty()) ": $liveText" else "", this)

    //endregion

    //region Private methods

    private fun triggerRecompose() {
        recomposeTrigger.value++
    }

    //Parse a template string to create a dynamic string result, processing functions and arguments as we go
    //  e.g. {label} or {graphic:someID} or {ListAnyTrueOrNone:Value,someText{Label}}
    fun stringFromTemplate(template: String?, control: Control): String {
        if (template.isNullOrEmpty()) {
            return ""
        }

        val resultSB = StringBuilder()
        var idx = 0
        while (idx < template.length) {
            var nextChar = template[idx++]
            when (nextChar) {
                '{' -> {  //Start of function, defined as {name[:args]}, where [:args] can be empty or contain more {} pair(s)
                    var tokenSB = StringBuilder()
                    var findingFunctionName = true
                    var functionName = ""
                    var arguments = ""
                    var numberOfBracesToSkip = 0
                    while (idx < template.length) {
                        nextChar = template[idx++]
                        when (nextChar) {
                            '{' -> {  //Embedded {} within current function definition
                                numberOfBracesToSkip++  //Start an embedded {} in argument value
                                tokenSB.append(nextChar)
                            }

                            ':' -> {  //Optional delimiter between function name and argument(s)
                                if (findingFunctionName) {
                                    functionName = tokenSB.toString()
                                    tokenSB.clear()
                                    findingFunctionName = false
                                }
                                else {
                                    tokenSB.append(nextChar)  //":" is within argument for function, following the original ":" that terminated the function name
                                }
                            }

                            '}' -> {  //End of function with no argument or end of embedded {} in argument
                                if (numberOfBracesToSkip == 0) {  //Closing } for function definition
                                    if (findingFunctionName) {
                                        functionName = tokenSB.toString()
                                        tokenSB.clear()
                                    }
                                    arguments = tokenSB.toString()
                                    tokenSB.clear()
                                    resultSB.append(invokeFunction(functionName, arguments, control))  //Execute function
                                    break
                                } else {
                                    //Closing } for embedded function
                                    tokenSB.append('}')
                                    numberOfBracesToSkip--
                                }
                            }

                            else -> tokenSB.append(nextChar)
                        }
                    }
                }

                else -> resultSB.append(nextChar)
            }
        }

        return resultSB.toString()
    }

    //Find a Control by its ID
    private fun findControl(id: String): Control {
        return if (controlIdLc == id.lowercase()) {  //Current control is the desired target
            this
        }
        else {  //Search this Control's children for desired Control
            findControlInChildren(id) ?: throw NotFoundException("findControl: Control not found by ID: $id")
        }
    }

    //Find a Control in the current control's children, to any depth (recursively)
    private fun findControlInChildren(id: String, baseControl: Control = this): Control? {
        val findIdLc = id.lowercase()
        for (childControl in baseControl.Controls) {
            if (childControl.controlIdLc == findIdLc) {
                return childControl
            }
            else {
                //This control didn't match, but see if any of its children do (recursively)
                val grandChildControl = findControlInChildren(findIdLc, childControl)
                if (grandChildControl != null) {
                    return grandChildControl
                }
            }
        }

        return null
    }

    //TODO Move to separate class
    private fun invokeFunction(functionName: String, arguments: String, control: Control): String {
        return when (functionName.lowercase()) {
            "value" -> funValue(arguments, control)  //Get Value for current or named control
            "label" -> funLabel(arguments, control)  //Get Label for current or named control
            "text" -> funText(arguments, control)  //Get Text for current or named control
            "ifnonzero" -> funIfNonZero(arguments)  //If current or named control's Value is non-zero, generate result string
            "listchildrennonemptynone" -> funListChildrenNonEmptyNone(arguments, control)  //Generate comma-delimited list from children with non-empty Values
            "listchildrentrueallnone" -> funListChildrenTrueAllNone(arguments, control)  //Generate comma-delimited list from children with "Checked" or "Indeterminate" Values
            "childrencheckedallsomenone" -> funChildrenCheckedAllSomeNone(control)  //Generate "All", "Some", or "None" based on children's checked state
            //TODO More functions. Do we need to use Control?
            else -> TODO()
        }
    }

    private fun splitArgs(args: String): List<String> {
        val split = args.split('|')
        return when (split.size) {
            0 -> throw IllegalArgumentException("Missing function name in splitArgs")

            1 -> listOf(
                split[0],
                ""
            )

            2 -> split

            else -> listOf(
                split[0],
                joinSubstrings(split, 1, '|')
            )
        }
    }

    private fun joinSubstrings(substrings: List<String>, startingIndex: Int, separator: Char): String {
        var resultSb = StringBuilder()
        var appendSeparator = false
        for (idx in substrings.indices) {
            if (idx >= startingIndex) {
                if (appendSeparator) {
                    resultSb.append(separator)
                } else {
                    appendSeparator = true
                }
                resultSb.append(substrings[idx])
            }
        }

        return resultSb.toString()
    }

    //endregion

    //region Embedded function implementations

    //Get Value field of current control or named control (by ID)
    //  arg: "" for current control, "someID" for named control
    private fun funValue(arg: String, control: Control): String {
        if (arg.isEmpty()) {
            return control.liveValue
        }
        return findControl(arg).liveValue
    }

    //Get Label field of current control or named control (by ID)
    //  arg: "" for current control, "someID" for named control
    private fun funLabel(arg: String, control: Control): String {
        if (arg.isEmpty()) {
            return control.Label
        }
        return findControl(arg).Label
    }

    //Get Text field of current control or named control (by ID)
    //  arg: "" for current control, "someID" for named control
    private fun funText(arg: String, control: Control): String {
        if (arg.isEmpty()) {
            return control.liveText
        }
        return findControl(arg).liveText
    }

    //Generate string based on child control if named child's Value is non-zero, else empty string
    //  arg = Child control ID|Template to use to generate result string
    private fun funIfNonZero(arg: String): String {
        var result = ""
        if (arg.isNotEmpty()) {
            val args = splitArgs(arg)

            //If named control's Value property is a non-zero string, return the computed value, else "" ("" Value defaults to "0")
            val foundControl = findControlInChildren(args[0])
            if (foundControl != null) {
                if (foundControl.liveValue.isNotEmpty() && foundControl.liveValue != "0") {
                    result = stringFromTemplate(args[1], foundControl)
                }
            }
        } else {
            throw IllegalArgumentException("IfNonZero called with no arguments")
        }

        return result
    }

    //Build comma-delimited list of data from all children with non-empty Value. Return "None" if empty list generated
    //  arg = String template for each element of the list with a non-empty Value
    private fun funListChildrenNonEmptyNone(arg: String, control: Control): String {
        var resultSB = StringBuilder()
        var prependComma = false

        for (control in control.Controls) {
            if (control.liveValue.isNotBlank()) {
                if (prependComma) {
                    resultSB.append(", ")
                } else {
                    prependComma = true
                }
                resultSB.append(stringFromTemplate(arg, control))
            }
        }

        return if (resultSB.isNotEmpty()) resultSB.toString() else "None"
    }

    //Build comma-delimited list of data from all children (checkboxes) in named collection with "CHECKED" or "INDETERMINATE" Value. Return "All" if all childen included, else "None" if empty list generated
    //  arg = "template", where "template" is the template to use to create each child value from the checked Control
    private fun funListChildrenTrueAllNone(arg: String, control: Control): String {
        var resultSB = StringBuilder()
        var prependComma = false
        var checkedCnt = 0

        for (control in control.Controls) {
            val checkedType = control.liveValue.lowercase()
            if (checkedType == "checked" || checkedType == "indeterminate") {
                checkedCnt++
                if (prependComma) {
                    resultSB.append(", ")
                } else {
                    prependComma = true
                }
                resultSB.append(stringFromTemplate(arg, control))
            }
        }

        return when {
            checkedCnt == Controls.size -> "All"
            resultSB.isNotEmpty() -> resultSB.toString()
            else -> "None"
        }
    }

    //Return "All" if all children/grandchildren checked, "Some" if some, but not all, children/grandchildren checked, "None" if no children/grandchildren checked
    private fun funChildrenCheckedAllSomeNone(control: Control): String {
        var checkedCnt = 0
        var uncheckedCnt = 0
        for (childControl in control.Controls) {
            if (childControl.liveValue == "checked") checkedCnt++
            if (childControl.liveValue == "unchecked") uncheckedCnt++
        }

        return when {
            (checkedCnt == Controls.size) -> "All"
            (uncheckedCnt == Controls.size) -> "None"
            else -> "Some"
        }
    }

    //endregion
}