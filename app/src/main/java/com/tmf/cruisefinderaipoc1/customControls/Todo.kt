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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

@Composable
fun Todo(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

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
            Row(modifier = Modifier.weight(1f)) {
                Text(
                    text = AnnotatedString("TODO: ${control.Control}: ${control.ID?:control.BoundValue}",
                        spanStyles = listOf(
                            AnnotatedString.Range(SpanStyle(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic), 0, 4)
                        )
                    ),

//                    "TODO: ${control.Control}: ${control.ID?:control.BoundValue}",
                    modifier = modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            //Control is collapsable
            CollapseIcon(expanded = expanded)
        }

        if (expanded) {  //Only generate embedded controls if card is expanded
            //Generate all the child controls defined for the Group
            EmbeddedControls(controls = control.Controls, control.recomposeTrigger.value, modifier = modifier.padding(horizontal = 5.dp), onValueChange = onValueChange)
        }
    }

}