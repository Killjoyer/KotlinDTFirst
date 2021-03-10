package com.example.task0activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class NumberActivity : AppCompatActivity() {
    private var numberView: TextView? = null
    private var dynamicNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dynamicNumber = intent.getIntExtra(IntentNames.NumberToPower.toString(), 0)
        numberView = findViewById(R.id.numberView)
        numberView?.text = dynamicNumber.toString()
    }

    fun onActivityButtonClick(view: View) {
        val sendIntent = Intent(this, SquareActivity::class.java)
                .apply { putExtra(IntentNames.NumberToPower.toString(), dynamicNumber) }

        startActivity(sendIntent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(dynamicNumberKey, dynamicNumber)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        dynamicNumber = savedInstanceState.getInt(dynamicNumberKey) + 1
        numberView?.text = dynamicNumber.toString()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        const val dynamicNumberKey = "Number"
    }
}