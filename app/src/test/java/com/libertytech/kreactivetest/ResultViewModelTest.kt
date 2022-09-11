package com.libertytech.kreactivetest

import com.libertytech.kreactivetest.ui.result.ResultViewModel
import org.junit.Test

const val FIRST_INT = 3
const val SECOND_INT = 5
const val FIRST_STRING = "fizz"
const val SECOND_STRING = "buzz"

class ResultViewModelTest {

    private val viewModel = ResultViewModel()

    @Test
    fun `Given multiple of firstInt When format index Then first Word`(){
        //Given
        val index = FIRST_INT * 2

        //When
        val result = viewModel.formatIndex(index, FIRST_INT, SECOND_INT, FIRST_STRING, SECOND_STRING)

        //Then
        assert(result == FIRST_STRING)
    }

    @Test
    fun `Given multiple of secondInt When format index Then second Word`(){
        //Given
        val index = SECOND_INT * 2

        //When
        val result = viewModel.formatIndex(index, FIRST_INT, SECOND_INT, FIRST_STRING, SECOND_STRING)

        //Then
        assert(result == SECOND_STRING)
    }

    @Test
    fun `Given multiple of firstInt and secondInt When format index Then first and second Word`(){
        //Given
        val index = FIRST_INT * SECOND_INT

        //When
        val result = viewModel.formatIndex(index, FIRST_INT, SECOND_INT, FIRST_STRING, SECOND_STRING)

        //Then
        assert(result == FIRST_STRING + SECOND_STRING)
    }

    @Test
    fun `Given no multiple When format index Then index`(){
        //Given
        val index = 2

        //When
        val result = viewModel.formatIndex(index, FIRST_INT, SECOND_INT, FIRST_STRING, SECOND_STRING)

        //Then
        assert(result == index.toString())
    }
}