package com.example.question3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val etFirstNumber = findViewById<EditText>(R.id.etFirstNumber)
        val etSecondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener {
            calculate(etFirstNumber.text.toString(), etSecondNumber.text.toString(), "add", tvResult)
        }

        btnSubtract.setOnClickListener {
            calculate(etFirstNumber.text.toString(), etSecondNumber.text.toString(), "subtract", tvResult)
        }

        btnMultiply.setOnClickListener {
            calculate(etFirstNumber.text.toString(), etSecondNumber.text.toString(), "multiply", tvResult)
        }

        btnDivide.setOnClickListener {
            calculate(etFirstNumber.text.toString(), etSecondNumber.text.toString(), "divide", tvResult)
        }

        // 显示从 MainActivity 传递过来的数据
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun calculate(num1: String, num2: String, operation: String, resultView: TextView) {
        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = num1.toDouble()
        val secondNumber = num2.toDouble()
        var result: Double? = null

        when (operation) {
            "add" -> result = firstNumber + secondNumber
            "subtract" -> result = firstNumber - secondNumber
            "multiply" -> result = firstNumber * secondNumber
            "divide" -> {
                if (secondNumber != 0.0) {
                    result = firstNumber / secondNumber
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                }
            }
        }

        result?.let {
            resultView.text = "Result: $it"
        }
    }
}

