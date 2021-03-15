package com.almoe.androidfundamentalscourse

val myFirstDice = Dice(24)
fun main() {
//    val diceRange = 1..6
//    val randomNumber = diceRange.random()
//    println("Random number is: $randomNumber")
//    var a = 1
//    repeat(10)
//    {
//        print("Repeat: $a,")
//        a++
//    }
    diceRoll6()
    println()
    diceRoll12()

}

fun diceRoll6() {
    println("Available Sides: ${myFirstDice.getAvailableSides()}")
    val side = myFirstDice.roll()
    println("Rolled Side: $side")
}

fun diceRoll12() {
    myFirstDice.setDiceSides(12)
    println("Available Sides: ${myFirstDice.getAvailableSides()}")
    val side = myFirstDice.roll()
    println("Rolled Side: $side")
}

class Dice (private val numSides : Int = 6) {
    private var sides = 6

    init {
        sides = numSides
    }

    fun roll(): Int {
        return (1..sides).random()
    }

    fun getAvailableSides(): Int {
        return sides
    }

    fun setDiceSides(numberOfSides: Int = 6) {
        sides = numberOfSides
    }
}