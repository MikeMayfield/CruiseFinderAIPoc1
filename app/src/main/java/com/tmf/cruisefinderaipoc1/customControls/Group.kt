package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Collapsable group of controls, displayed within a Card indented within its parent
 */
@Composable
fun Group(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded = remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a use of recomposeTrigger to force Compose to use it

    Log.v("Group", "Compose ${control.controlIdLc}")

    ExpandableCard(
        expanded = expanded
    ) {

        //Group's display body is generated from its templated Label and Text, if any
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(12.dp)) {  //Label and optional text value
            //TODO Support optional leading icon
            Icon(Icons.Filled.Home,"TODO", modifier = Modifier.padding(end = 5.dp))

            Text(text = control.annotatedLabel,
                color = if (control.isValid) MaterialTheme.colorScheme.primary else Color.Red,
                maxLines = if (expanded.value) 10 else 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )

            //Control is collapsable
            CollapseIcon(expanded = expanded.value)
        }

        if (expanded.value) {  //Only generate embedded controls if card is expanded
            //Generate all the child controls defined for the Group
            EmbeddedControls(controls = control.Controls, control.recomposeTrigger.value,  modifier = modifier.padding(horizontal = 5.dp), onValueChange = {
                onValueChange(it)
                control.recomposeTrigger.value++  //Force control to recompose in case value change effects layout
            })
        }
    }
}