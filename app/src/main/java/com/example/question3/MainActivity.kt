package com.example.question3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartCalculator = findViewById<Button>(R.id.btnStartCalculator)
        val btnStartNumberDraw = findViewById<Button>(R.id.btnStartNumberDraw)

        btnStartCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!")
            startActivity(intent)
        }

        btnStartNumberDraw.setOnClickListener {
            val intent = Intent(this, NumberDrawActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity!")
            startActivity(intent)
        }
    }
}

