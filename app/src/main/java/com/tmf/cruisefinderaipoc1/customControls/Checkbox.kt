package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
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
    useCard: Boolean = true,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded = remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Log.v("Checkbox", "Compose ${control.controlIdLc}")

    if (useCard) {
        ExpandableCard(
            expanded = expanded
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = (control.liveValue == "checked"),
                    onCheckedChange = {
                        control.liveValue = if (it) "checked" else "unchecked"
                        onValueChange(control)
                    }
                )

                Text(
                    modifier = Modifier.padding(start = 2.dp)
                        .clickable {
                            control.liveValue = if (control.liveValue == "checked") "unchecked" else "checked"
                            onValueChange(control)
                        },
                    text = control.Label,
                    fontWeight = Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    } else {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = (control.liveValue == "checked"),
                modifier = modifier.padding(start = 2.dp),
                onCheckedChange = {
                    control.liveValue = if (it) "checked" else "unchecked"
                    onValueChange(control)
                }
            )

            Text(
                modifier = Modifier.padding(start = 2.dp)
                    .clickable {
                        control.liveValue = if (control.liveValue == "checked") "unchecked" else "checked"
                        onValueChange(control)
                    },
                text = control.Label,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}