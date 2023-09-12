package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

@Composable
fun Label(
    control: Control,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    Row(modifier = modifier) {
        val dynamicText = control.stringFromTemplate(control.Text, control)
        Text(
            text = control.stringFromTemplate(control.Label, control) + if (dynamicText.isNotEmpty()) ": " else "",
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold,
            maxLines = if (control.SingleLine) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis
        )
        if (dynamicText.isNotEmpty()) {
            Text(
                text = dynamicText,
                modifier = Modifier.padding(vertical = 5.dp),
                maxLines = if (control.SingleLine) 1 else Int.MAX_VALUE,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}