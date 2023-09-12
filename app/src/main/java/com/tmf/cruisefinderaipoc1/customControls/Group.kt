package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Collapsable group of controls, displayed within a Card indented within its parent
 */
@Composable
fun Group(
    control: Control,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false)}

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
            .clickable {
                expanded = !expanded
            }
    ) {

        //Group's display body is generated from its templated Label and Text, if any
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(start = 12.dp)) {  //Label and optional text value
            Text(text = control.annotatedLabel,
                maxLines = if (expanded) 5 else 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )

//            Row(modifier = Modifier.weight(1f)) {
//                Text(  //Label
//                    text = control.Label + if (control.liveText.isNotEmpty()) ": " else "",
////                    modifier = Modifier.padding(5.dp),
//                    fontWeight = FontWeight.Bold,
//                    maxLines = if (expanded) 5 else 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                if (control.liveText.isNotEmpty()) {  //Text, if any
//                    Text(
//                        text = control.liveText,
////                        modifier = Modifier.padding(end = 10.dp),
//                        maxLines = if (expanded) 5 else 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                }
//            }

            //Control is collapsable
            CollapseIcon(expanded = expanded)
        }

        if (expanded) {  //Only generate embedded controls if card is expanded
            //Generate all the child controls defined for the Group
            EmbeddedControls(controls = control.Controls, modifier = modifier.padding(horizontal = 5.dp), onValueChange = onValueChange)
        }
    }
}