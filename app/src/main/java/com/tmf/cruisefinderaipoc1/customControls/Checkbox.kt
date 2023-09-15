package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Collapsable group of controls, displayed within a Card indented within its parent
 */
@Composable
fun Checkbox(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Log.v("Checkbox", "Compose ${control.controlIdLc}")

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = (control.liveValue == "checked"),
            modifier = modifier,
            onCheckedChange = {
                control.liveValue = if (it) "checked" else "unchecked"
                onValueChange(control)
            }
        )

        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = control.Label
        )
    }
}