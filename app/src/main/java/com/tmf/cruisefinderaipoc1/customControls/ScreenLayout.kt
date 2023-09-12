package com.tmf.cruisefinderaipoc1.customControls

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tmf.cruisefinderaipoc1.models.BoundData
import com.tmf.cruisefinderaipoc1.models.Control
import com.tmf.cruisefinderaipoc1.models.Layout

/**
 * Base of table-driven screen layout. Generates a full layout from a Layout JSON string
 */
@Composable
fun ScreenLayout(layout: Layout, boundData: BoundData, modifier: Modifier = Modifier) {  //TODO: Use observable layout and data
    initChildControlsRecursively(layout.Controls)  //Init each control in layout, from the bottom of the tree to the top (to provide child data to parent, if needed)

    EmbeddedControls(controls = layout.Controls, modifier)  //Display the controls
}

private fun initChildControlsRecursively(controls: List<Control>) {
    for (control in controls) {
        if (control.Controls.isNotEmpty()) {  //Init any children for control
            initChildControlsRecursively(control.Controls)
        }
        Log.v("ScreenLayout.initChildControlsRecursively", control.toString())  //TODO
        control.init()  //Init the control itself
    }
}