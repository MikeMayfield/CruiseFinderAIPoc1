package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var isValid by remember { mutableStateOf(!control.isValid)}

    Button(modifier = modifier.fillMaxWidth().padding(10.dp),
        onClick = {
        //TODO
    }) {
        Text(text = control.Label,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth())
    }

}