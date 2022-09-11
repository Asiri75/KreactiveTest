package com.libertytech.kreactivetest.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {

    private val resultListMutableLiveData = MutableLiveData<List<String>>()

    fun getResultListLiveData(): LiveData<List<String>> = resultListMutableLiveData


    fun buildList(
        firstIntField: String,
        secondIntField: String,
        firstTextField: String,
        secondTextField: String,
        limitField: String
    ) {
        MutableList(limitField.toInt()) { index ->
            formatIndex(
                index + 1,
                firstIntField.toInt(),
                secondIntField.toInt(),
                firstTextField,
                secondTextField,
            )
        }.let {
            resultListMutableLiveData.value = it
        }
    }

    internal fun formatIndex(number: Int, firstInt: Int, secondInt: Int, firstText: String, secondText: String) = when {
        number % (firstInt * secondInt) == 0 -> firstText + secondText
        number % (firstInt) == 0 -> firstText
        number % (secondInt) == 0 -> secondText
        else -> number.toString()
    }
}