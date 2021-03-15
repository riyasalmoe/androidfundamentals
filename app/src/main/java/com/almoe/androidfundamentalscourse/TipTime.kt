package com.almoe.androidfundamentalscourse

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.almoe.androidfundamentalscourse.databinding.ActivityTipTimeBinding
import java.text.NumberFormat

class TipTime : AppCompatActivity() {

    //before using the below method, view binding feature must be added in gradle script(:app)
    //    buildFeatures {
    //        viewBinding = true
    //    }

    private lateinit var bindingTipTime: ActivityTipTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTipTime = ActivityTipTimeBinding.inflate(layoutInflater)
        setContentView(bindingTipTime.root)
//        setContentView(R.layout.activity_tip_time)

        bindingTipTime.calculateButton.setOnClickListener { calculateTip() }
        bindingTipTime.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun calculateTip() {
        val stringInTextField = bindingTipTime.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }
        val tipPercentage = when (bindingTipTime.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost

        if (bindingTipTime.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        bindingTipTime.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            //Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
//end of class