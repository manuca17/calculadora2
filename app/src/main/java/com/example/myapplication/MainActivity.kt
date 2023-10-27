    package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private var currentNumber: Double = 0.0
    private var previousNumber: Double = 0.0
    private var currentOperator: String? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            appendText(binding.button0)
        }

        binding.button1.setOnClickListener {
            appendText(binding.button1)
        }

        binding.button2.setOnClickListener {
            appendText(binding.button2)
        }

        binding.button3.setOnClickListener {
            appendText(binding.button3)
        }

        binding.button4.setOnClickListener {
            appendText(binding.button4)
        }

        binding.button5.setOnClickListener {
            appendText(binding.button5)
        }

        binding.button6.setOnClickListener {
            appendText(binding.button6)
        }

        binding.button7.setOnClickListener {
            appendText(binding.button7)
        }

        binding.button8.setOnClickListener {
            appendText(binding.button8)
        }

        binding.button9.setOnClickListener {
            appendText(binding.button9)
        }

        binding.buttonDecimal.setOnClickListener {
            appendText(binding.buttonDecimal)
        }


        binding.buttonDivide.setOnClickListener {
            currentOperator = "/"
            previousNumber = binding.workingsView.text.toString().toDouble()
            binding.workingsView.text = ""
        }

        binding.buttonMultiply.setOnClickListener {
            currentOperator = "*"
            previousNumber = binding.workingsView.text.toString().toDouble()
            binding.workingsView.text = ""
        }

        binding.buttonMinus.setOnClickListener {
            currentOperator = "-"
            previousNumber = binding.workingsView.text.toString().toDouble()
            binding.workingsView.text = ""
        }

        binding.buttonPlus.setOnClickListener {
            currentOperator = "+"
            previousNumber = binding.workingsView.text.toString().toDouble()
            binding.workingsView.text = ""
        }

        binding.equalsButton.setOnClickListener {
            operators()
        }


        binding.buttonClear.setOnClickListener {
            binding.workingsView.text = "0"
        }




    }

    private fun operators(){
        if (currentOperator != null) {
            val currentNumberStr = binding.workingsView.text.toString()
            val result = when (currentOperator) {
                "+" -> previousNumber + currentNumberStr.toDouble()
                "-" -> previousNumber - currentNumberStr.toDouble()
                "*" -> previousNumber * currentNumberStr.toDouble()
                "/" -> previousNumber / currentNumberStr.toDouble()
                else -> 0.0
            }
            binding.workingsView.text = result.toString()
            currentNumber = result
            currentOperator = null
        }
    }

    private fun appendText(view: Button) {
        val currentText = binding.workingsView.text.toString()
        if (currentText == "0") {
            binding.workingsView.text = view.text
        } else {
            binding.workingsView.append(view.text)
        }
    }



    }


