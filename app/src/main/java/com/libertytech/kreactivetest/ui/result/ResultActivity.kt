package com.libertytech.kreactivetest.ui.result

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.libertytech.kreactivetest.databinding.ActivityResultBinding

const val FIRST_INT_KEY = "FIRST_INT_KEY"
const val SECOND_INT_KEY = "SECOND_INT_KEY"
const val FIRST_STRING_KEY = "FIRST_STRING_KEY"
const val SECOND_STRING_KEY = "SECOND_STRING_KEY"
const val LIMIT_KEY = "LIMIT_KEY"

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = ViewModelProvider(this)[ResultViewModel::class.java]

        model.getResultListLiveData().observe(this) { resultList ->
            //Normally, we set the adapter first, then update.
            //However we simplified here
            binding.root.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, resultList
            )
        }

        prepareList(model)
    }

    /**
     * Send form data to viewModel for computing
     */
    private fun prepareList(model: ResultViewModel) {
        if (areExtraValid()) {
            model.buildList(
                firstIntField = intent.getStringExtra(FIRST_INT_KEY).orEmpty(),
                secondIntField = intent.getStringExtra(SECOND_INT_KEY).orEmpty(),
                firstTextField = intent.getStringExtra(FIRST_STRING_KEY).orEmpty(),
                secondTextField = intent.getStringExtra(SECOND_STRING_KEY).orEmpty(),
                limitField = intent.getStringExtra(LIMIT_KEY).orEmpty()
            )
        } else {
            finish()
        }
    }

    /**
     * Check extra if not null
     */
    private fun areExtraValid() =
        !intent.getStringExtra(FIRST_INT_KEY).isNullOrBlank()
                && !intent.getStringExtra(SECOND_INT_KEY).isNullOrBlank()
                && !intent.getStringExtra(FIRST_STRING_KEY).isNullOrBlank()
                && !intent.getStringExtra(SECOND_STRING_KEY).isNullOrBlank()
                && !intent.getStringExtra(LIMIT_KEY).isNullOrBlank()
}