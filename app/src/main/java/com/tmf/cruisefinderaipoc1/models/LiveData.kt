package com.tmf.cruisefinderaipoc1.models

object LiveData {
    var boundData: BoundData = BoundData(listOf())  //Current BoundData collection
    var repeaterBoundData: BoundData = BoundData(listOf())  //Current BoundData collection for current Repeater

    var searchBoundData: BoundData = BoundData(listOf())  //BoundData for Search screen

    //Save changes to current BoundData collection to repository
    fun saveChanges() {
        //TODO Implement
    }
}