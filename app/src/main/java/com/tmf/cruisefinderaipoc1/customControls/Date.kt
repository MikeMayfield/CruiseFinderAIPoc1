package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
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
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale


/**
 * Label and text input box
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Date(
    control: Control,
    recomposeTrigger: Int,
    modifier: Modifier = Modifier,
    onValueChange: (changedControl: Control) -> Unit = {}
) {
    var expanded = remember { mutableStateOf(false) }
    if (recomposeTrigger == -1) return  //NOTE: This will never be true. Used to force a "use" of recomposeTrigger so that Compose will call this method when trigger is changed

    Log.v("Date", "Compose ${control.controlIdLc}")

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
            val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
            val someDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(100), ZoneId.systemDefault())

            // set the initial date
            val calendar = Calendar.getInstance()
            if (control.liveValue.isNotEmpty()) {
                calendar.time = formatter.parse(control.liveValue) // all done
            } else {
                calendar.set(2005, 1, 1)
            }
            val minDate = LocalDate.now().minusYears(100).year  //At most 100 years old
            val maxDate = LocalDate.now().minusYears(18).year  //At least 18 years old

            val datePickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis,
                yearRange = IntRange(minDate, maxDate)
            )

            DatePickerDialog(
                onDismissRequest = {
                    expanded.value = false
                },
                confirmButton = {
                    TextButton(onClick = {
                        expanded.value = false
                        val selectedDate = Instant.ofEpochMilli(datePickerState.selectedDateMillis!!).atZone(ZoneId.of("GMT")).toLocalDate()
                        control.liveValue = DateTimeFormatter.ofPattern("M/d/yyyy").format(selectedDate)
                        onValueChange(control)
                    }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        expanded.value = false
                    }) {
                        Text(text = "Cancel")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState
                )
            }
        }
    }
}