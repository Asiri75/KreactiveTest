package com.libertytech.kreactivetest.ui.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.libertytech.kreactivetest.R

class ResultActivity : AppCompatActivity() {
    private lateinit var model: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val model = ViewModelProvider(this)[ResultViewModel::class.java]
    }
}