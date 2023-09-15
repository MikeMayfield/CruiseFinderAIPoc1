package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tmf.cruisefinderaipoc1.models.Control

@Composable
fun EmbeddedControls(
    controls: List<Control>,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    for (control in controls) {
        when (control.Control.lowercase()) {
            "button" -> Button(control, control.recomposeTrigger.value, modifier, onValueChange)
            "checkbox" -> Checkbox(control, control.recomposeTrigger.value, modifier, onValueChange)
            "checkboxgroup" -> CheckboxGroup(control, control.recomposeTrigger.value, modifier, onValueChange)
            "date" -> Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "deckmap" -> Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "dropdown" -> Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "group" -> Group(control, control.recomposeTrigger.value, modifier, onValueChange)
            "label" ->  Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "loyaltytextinput" -> LoyaltyTextInput(control, control.recomposeTrigger.value, modifier, onValueChange)
            "photo" -> Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "repeater" -> Todo(control, control.recomposeTrigger.value, modifier, onValueChange)
            "textinput" -> TextInput(control, control.recomposeTrigger.value, modifier, onValueChange)
            else -> TODO()
        }
    }
}