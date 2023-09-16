package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Label and text input box
 */
@Composable
fun Dropdown(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Log.v("Dropdown", "Compose ${control.controlIdLc}")

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                expanded = !expanded
            }
    ) {

        //Group's display body is generated from its templated Label and Text, if any
        Row(verticalAlignment = Alignment.Top, modifier = modifier.padding(12.dp)) {  //Label and optional text value
            //TODO Support optional leading icon

            if (expanded) {
                Text(
                    text = "${control.Label}:",
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Red,
                    fontWeight = FontWeight.Bold,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

            }
            else {
                Text(
                    text = control.annotatedLabel,
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Red,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }

            //Control is collapsable
            CollapseIcon(expanded = expanded)
        }

        if (expanded) {  //Only generate input field if card is expanded
            var prependDivider = false
            for (choice in control.choices) {
                if (prependDivider) {
                    Divider(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp))
                } else {
                    prependDivider = true
                }

                DropdownMenuItem(
                    text = { Text(choice) },
                    modifier = Modifier.padding(start = 24.dp),
                    onClick = {
                        control.liveValue = choice
                        expanded = false
                        onValueChange(control)
                    }
                )
            }
        }
    }
}