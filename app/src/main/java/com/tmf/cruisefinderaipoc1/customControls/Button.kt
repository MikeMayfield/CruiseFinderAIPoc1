package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Collapsable group of controls, displayed within a Card indented within its parent
 */
@Composable
fun Button(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Button(modifier = modifier.fillMaxWidth().padding(10.dp),
        onClick = {
            //TODO Execute OnClick handler for Control
            onValueChange(control)
        }
    ) {
        Text(text = control.Label,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth())
    }

}