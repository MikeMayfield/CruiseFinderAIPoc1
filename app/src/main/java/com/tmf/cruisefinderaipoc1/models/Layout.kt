package com.tmf.cruisefinderaipoc1.models

import kotlinx.serialization.Serializable

@Serializable
data class Layout(
    val Controls: List<Control>  //Collection of Controls that define the entire screen layout
)