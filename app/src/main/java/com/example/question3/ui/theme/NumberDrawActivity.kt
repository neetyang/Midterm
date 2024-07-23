package com.example.question3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class NumberDrawActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_draw)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            val numberOfDraws = spinner.selectedItem.toString().toInt()
            val drawnNumbers = drawNumbers(numberOfDraws)
            textView.text = "Drawn Numbers: ${drawnNumbers.joinToString(", ")}"
        }

        // 显示从 MainActivity 传递过来的数据
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun drawNumbers(count: Int): List<Int> {
        val numbers = (1..100).toMutableList()
        numbers.shuffle()
        return numbers.take(count)
    }
}

