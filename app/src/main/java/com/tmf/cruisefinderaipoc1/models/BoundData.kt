package com.tmf.cruisefinderaipoc1.models

import kotlinx.serialization.Serializable

@Serializable
data class BoundData(
    val Data: List<DataValue>  //Collection of data values, including possible subcollections of data values
) {
    private val mutableData = mutableMapOf<String, DataValue>()

    //Optimized way to find bound data by key using a map
    private val _idToData: Map<String, DataValue> by lazy {
        mutableData.clear()
        for (item in Data) {
            mutableData[item.ID.lowercase()] = item
        }

        mutableData
    }

    //Get Value field of DataValue by ID (Default = "")
    fun value(id: String?) : String {
        val dataValue = _idToData[(id ?: "").lowercase()]
        return if (dataValue != null) {
            if (dataValue.Value != null) {
                dataValue.Value!!
            } else {
                ""
            }
        } else {
            ""
        }
    }

    fun addValue(id: String, value: String = "") : DataValue {
        if (dataValue(id) == null) {
            mutableData[id] = DataValue(id)
        }

        return dataValue(id)!!
    }

    //Get DataValue for ID
    fun dataValue(id: String?) : DataValue? {
        return _idToData[(id ?: "").lowercase()]
    }
}