package com.example.task0activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SquareActivity : AppCompatActivity() {
    var squareView: TextView? = null
    var number: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)
        squareView = findViewById(R.id.textView)
        number = intent.getIntExtra(IntentNames.NumberToPower.toString(), 99)
        squareView?.text = (number * number).toString()
    }

    fun onActivityButtonClick(view: View) {
        val sendIntent = Intent(this, NumberActivity::class.java)
                .apply { putExtra(IntentNames.NumberToPower.toString(), number) }
        startActivity(sendIntent)
    }

    companion object {

    }
}