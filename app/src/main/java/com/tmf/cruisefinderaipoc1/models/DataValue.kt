package com.tmf.cruisefinderaipoc1.models

import kotlinx.serialization.Serializable

@Serializable
data class DataValue(
    val ID: String,  //Unique ID of data value within BoundData collection
    var Value: String? = null,  //Value, if collection of subdata not defined
    val Collection: List<BoundData>? = null  //Optional collection of subdata
)