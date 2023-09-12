package com.tmf.cruisefinderaipoc1.customControls

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun CollapseIcon(
    expanded: Boolean
) {
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )

//    IconButton(
//        modifier = Modifier.rotate(rotationState),
//        onClick = {
////            onClick(!expanded)
//        }) {
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Collapse/Expand Arrow",
            modifier = Modifier.rotate(rotationState)
        )
//    }
}