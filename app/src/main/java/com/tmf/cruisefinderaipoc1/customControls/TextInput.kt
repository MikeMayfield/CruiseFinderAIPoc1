package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun TextInput(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded = remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Log.v("TextInput", "Compose ${control.controlIdLc}")

    ExpandableCard(
        expanded = expanded
    ) {

        //Group's display body is generated from its templated Label and Text, if any
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(12.dp)) {  //Label and optional text value
            //TODO Support optional leading icon

            if (expanded.value) {
                Text(
                    text = "${control.Label}:",
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Red,
                    fontWeight = FontWeight.Bold,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

            } else {
                Text(
                    text = control.annotatedLabel,
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Red,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }

            //Control is collapsable
            CollapseIcon(expanded = expanded.value)
        }

        if (expanded.value) {  //Only generate input field if card is expanded
            OutlinedTextField(
                value = control.liveValue,
                singleLine = true,
                modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 5.dp),
                isError = !control.isValid,
                supportingText = {
                    if (!control.isValid) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Value is incorrect",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    if (!control.isValid)
                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
                },
                onValueChange = {
                    control.liveValue = it
                    onValueChange(control)
                }
            )
        }
    }
}