package com.almoe.androidfundamentalscourse

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class DiceRoller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val resultText: TextView = findViewById(R.id.ResultText)
        val rollButton: Button = findViewById(R.id.RollButton)

        resultText.text = "Start!"

        rollButton.setOnClickListener {
//            Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT).show()

            val resultTextView1: TextView = findViewById(R.id.RolledNumber1)
            val resultTextView2: TextView = findViewById(R.id.RolledNumber2)
            val newDice1 = Dice(6)
            val newDice2 = Dice(6)
            val colorRed = ContextCompat.getColor(this, R.color.red)
            val colorWhite = ContextCompat.getColor(this, R.color.white)
            val colorGreen = ContextCompat.getColor(this, R.color.green)

            resultTextView1.text = newDice1.roll().toString()
            resultTextView2.text = newDice2.roll().toString()

            if (resultTextView1.text == resultTextView2.text) {
                resultText.setBackgroundColor(colorWhite)
                resultText.setTextColor(colorGreen)
                resultText.textSize = 50F
                resultText.text = "Congratulations!"
            } else {
                resultText.textSize = 80F
                resultText.setBackgroundColor(colorRed)
                resultText.setTextColor(colorWhite)
                resultText.text = "Try again!"
            }

            updateDiceImage(resultTextView1.text.toString().toInt(), findViewById(R.id.DiceImage1))
            updateDiceImage(resultTextView2.text.toString().toInt(), findViewById(R.id.DiceImage2))
        }
    }

    private fun updateDiceImage(rolledNumber: Int, diceObject: ImageView) {
        val drawableResource = when (rolledNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceObject.setImageResource(drawableResource)
    }
}

