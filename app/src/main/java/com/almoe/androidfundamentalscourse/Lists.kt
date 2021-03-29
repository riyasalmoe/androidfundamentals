package com.almoe.androidfundamentalscourse

fun main() {

    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)

    println("List: $numbers")
    println("Size: ${numbers.size}")
    println("Last Index: ${numbers.size - 1}")
    println("Last Element: ${numbers[numbers.size - 1]}")
    println("First: {${numbers.first()}}")
    println("Last: {${numbers.last()}}")

    println("Contains 4? {${numbers.contains(4)}}")
    println("Contains 7? {${numbers.contains(7)}}")

    //read only/ immutable list of items
    var fruits = listOf("apple", "orange", "grapes")
    println("Fruits non changeable list: $fruits")

    //changeable / mutable list of items
    var colors = mutableListOf("green", "orange", "blue")
    colors.add("purple")
    colors[0] = "yellow"
    println("Colors changeable list: $colors")
    println("Reversed list: ${colors.reversed()}")
    println("Sorted list: ${colors.sorted()}")

    //it is possible to sort immutable list
    // actual list won't get effected, you get a new list
    println("\nOriginal immutable list: $fruits")
    println("Sorted immutable list: ${fruits.sorted()}\n")

    println("Mutable List")
    println("=============================================")
    val entrees: MutableList<String> = mutableListOf()
    println("Blank Entrees: $entrees")

    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")

    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")

    var moreItems = listOf("ravioli", "lasagna", "fettucine")

    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")

    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")

    //trying to remove item that doesn't exists
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
    println("Entrees: $entrees")

    //remove item at specific index
    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")

    //clear the entire list
    entrees.clear()
    println("Entrees: $entrees")

    //check whether list is empty
    println("Empty? ${entrees.isEmpty()}")

    println("\n while loop")
    println("============================================")
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalGuests")

    println("\n for loop")
    println("============================================")
//    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
//    for (name in names){
//        println("Name: $name")
//    }
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }
}