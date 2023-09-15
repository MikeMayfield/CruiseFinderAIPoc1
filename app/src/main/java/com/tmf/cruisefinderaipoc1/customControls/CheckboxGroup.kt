package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.models.Control

/**
 * Collapsable group of controls, displayed within a Card indented within its parent
 */
@Composable
fun CheckboxGroup(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a use of recomposeTrigger to force Compose to use it

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                expanded = !expanded
            }
    ) {

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 12.dp)) {
            val tristate: ToggleableState = when (control.liveValue) {
                "checked" -> ToggleableState.On
                "unchecked" -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            }

            TriStateCheckbox(state = tristate,
                onClick = {
                    control.liveValue = changeChildrenToToggleTristate(tristate, control.Controls)
                    onValueChange(control)
                }
            )

            if (expanded) {
                Text(
                    modifier = modifier.padding(start = 2.dp, top = 12.dp).weight(1f),
                    text = control.annotatedLabel,
                    fontWeight = FontWeight.Bold,
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Color.Red,
                    maxLines = if (expanded) 5 else 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            else {
                Text(
                    modifier = modifier.padding(start = 2.dp).weight(1f),
                    text = control.annotatedLabel,
                    fontWeight = FontWeight.Bold,
                    color = if (control.isValid) MaterialTheme.colorScheme.primary else Color.Red,
                    maxLines = if (expanded) 5 else 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            //Control is collapsable
            CollapseIcon(expanded = expanded)
        }

        if (expanded) {  //Only generate embedded controls if card is expanded
            val childValueChangeHandler = {
                //Set tristate checked value as On: All children checked, Indeterminate: Some children checked, or Off: No children checked
                var checkedCnt = 0
                var uncheckedCnt = 0
                for (childControl in control.Controls) {
                    if (childControl.liveValue == "checked") checkedCnt++
                    if (childControl.liveValue == "unchecked") uncheckedCnt++
                }

                control.liveValue = when {
                    (checkedCnt == control.Controls.size) -> "checked"
                    (uncheckedCnt == control.Controls.size) -> "unchecked"
                    else -> "indeterminate"
                }

                onValueChange(control)
            }

            //Generate all the child Checkboxes and CheckboxGroups for this group
            for (control in control.Controls) {
                when (control.Control.lowercase()) {
                    "checkbox" -> Checkbox(control, control.recomposeTrigger.value, modifier = modifier.padding(start = 5.dp),
                        onValueChange = { childValueChangeHandler() })
                    "checkboxgroup" -> CheckboxGroup(control, control.recomposeTrigger.value, modifier = modifier.padding(start = 5.dp),
                        onValueChange = { childValueChangeHandler() })
                }
            }
        }
    }
}

fun changeChildrenToToggleTristate(tristate: ToggleableState, controls: List<Control>): String {
    //Set checked/unchecked for all child Checkboxes and let their change event(s) update Tristate automatically in OnChange events
    //  If currently Checked, set all children to "unchecked", which will cause the group to be "unchecked"
    //  If currently Unchecked or Indeterminate (some checked), set all children to "checked", which will cause the group to be "checked"
    val newCheckedState = if (tristate == ToggleableState.On) "unchecked" else "checked"
    for (control in controls) {
        if (control.liveValue != newCheckedState) {
            control.liveValue = newCheckedState
        }
    }

    return newCheckedState
}
