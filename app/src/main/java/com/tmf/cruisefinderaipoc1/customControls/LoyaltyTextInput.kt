package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tmf.cruisefinderaipoc1.models.Control

@Composable
fun LoyaltyTextInput(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    //TODO Automatically lookup loyalty number for non-empty value (process lookup in background thread. Only process once)
    TextInput(control, recomposeTrigger, modifier, onValueChange)
}
