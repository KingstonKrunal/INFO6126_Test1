package com.example.krunalshah.test1krunalshah

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var radioGroup: RadioGroup
    lateinit var textView: TextView
    lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.colourSpinner)
        textView = findViewById(R.id.nameTextView)
        radioGroup = findViewById(R.id.colourRadioButtonGroup)
        resetButton = findViewById(R.id.resetButton)

        val spinneradapter = ArrayAdapter.createFromResource(
            this,
            R.array.colourArray,
            android.R.layout.simple_spinner_item
        )

        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinneradapter

        spinner.onItemSelectedListener = this

        resetButton.setOnClickListener(View.OnClickListener {
            textView.setBackgroundColor(Color.parseColor("red"))
            spinner.setSelection(0)
        })
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val spinnerPosition = p0?.getItemAtPosition(p2)
        Log.d(spinnerPosition.toString(), "position")

        if (spinnerPosition == "Red") {
            textView.setBackgroundColor(Color.parseColor("red"))
            radioGroup.check(R.id.redRadioButton)
        }
        if (spinnerPosition == "Green") {
            textView.setBackgroundColor(Color.parseColor("green"))
            radioGroup.check(R.id.greenRadioButton)
        }
        if (spinnerPosition == "Blue"){
            textView.setBackgroundColor(Color.parseColor("blue"))
            radioGroup.check(R.id.blueRadioButton)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
//        textView.setBackgroundColor(Color.parseColor("Red"))
    }

    fun onRadioClick(view: android.view.View) {
        when(view.id) {
            R.id.redRadioButton->{
                textView.setBackgroundColor(Color.parseColor("red"))
                spinner.setSelection(0)
            }
            R.id.greenRadioButton-> {
                textView.setBackgroundColor(Color.parseColor("green"))
                spinner.setSelection(1)
            }
            R.id.blueRadioButton-> {
                textView.setBackgroundColor(Color.parseColor("blue"))
                spinner.setSelection(2)
            }
        }
    }
}