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

    //list use case example
    println("")
    println("list use case example")
    println("=======================")
    listUseCase()

    //order class
    println("")
    println("class and list use case")
    println("=======================")
    val ordersList = mutableListOf<Order>()

    val order1 = Order(1)
    order1.addItem(Noodles())
//    order1.print()
    ordersList.add(order1)
//    println()

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
//    order2.print()
    ordersList.add(order2)
//    println()

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
//    order3.print()
    ordersList.add(order3)

    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion", "Capsicum"))
    ordersList.add(order4)

    ordersList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach", "Cabbage"))
    )

    for (order in ordersList) {
        order.print()
        println("=============================")
    }
}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()

    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }

    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    fun print() {
        println("Order #$orderNumber")
        var total = 0
        for (item in itemList) {
            println("$item : $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

//Only one parameter can be marked as vararg and is usually the last parameter in the list.
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return if (toppings.isEmpty()) {
            "$name Chef's Choice"
        } else {
            "$name ${toppings.joinToString(" | ")}"
        }
    }
}

fun listUseCase() {
    val noodles = Noodles()
    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables()
    println(noodles)
    println(vegetables)
    println(vegetables2)
}