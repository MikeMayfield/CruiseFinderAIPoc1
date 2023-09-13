package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tmf.cruisefinderaipoc1.models.Control

@Composable
fun EmbeddedControls(
    controls: List<Control>,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    for (control in controls) {
        when (control.Control.lowercase()) {
            "button" -> Button(control, modifier, onValueChange)
            "checkbox" -> Todo(control, modifier, onValueChange)
            "checkboxgroup" -> Todo(control, modifier, onValueChange)
            "date" -> Todo(control, modifier, onValueChange)
            "deckmap" -> Todo(control, modifier, onValueChange)
            "dropdown" -> Todo(control, modifier, onValueChange)
            "group" -> Group(control, modifier, onValueChange)
            "label" ->  Label(control, modifier, onValueChange)
            "loyaltytextinput" -> Todo(control, modifier, onValueChange)
            "photo" -> Todo(control, modifier, onValueChange)
            "repeater" -> Todo(control, modifier, onValueChange)
            "textinput" -> TextInput(control, modifier, onValueChange)
            else -> TODO()
        }
    }
}