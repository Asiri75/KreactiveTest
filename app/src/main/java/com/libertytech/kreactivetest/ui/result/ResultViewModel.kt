package com.libertytech.kreactivetest.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel: ViewModel() {

    private val resultListMutableLiveData = MutableLiveData<List<String>>()

    fun getResultListLiveData() : LiveData<List<String>> = resultListMutableLiveData

    fun buildList(
        firstIntField: String,
        secondIntField: String,
        firstTextField: String,
        secondTextField: String,
        limitField: String
    ) {

    }
}