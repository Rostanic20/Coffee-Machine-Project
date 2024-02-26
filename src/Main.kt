class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var disposableCups = 9
    var money = 550

    fun processInput(input: String) {
        when (input) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> return
        }
    }

    private fun remaining() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans g of coffee beans")
        println("$disposableCups disposable cups")
        println("$$money of money")
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readLine()!!) {
            "1" -> {
                if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 250
                    coffeeBeans -= 16
                    disposableCups -= 1
                    money += 4
                } else {
                    println("Sorry, not enough resources!")
                }
            }
            "2" -> {
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    disposableCups -= 1
                    money += 7
                } else {
                    println("Sorry, not enough resources!")
                }
            }
            "3" -> {
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    disposableCups -= 1
                    money += 6
                } else {
                    println("Sorry, not enough resources!")
                }
            }
            "back" -> return
        }
    }

    private fun fill() {
        println("Write how many ml of water you want to add:")
        water += readLine()!!.toInt()
        println("Write how many ml of milk you want to add:")
        milk += readLine()!!.toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += readLine()!!.toInt()
        println("Write how many disposable cups you want to add:")
        disposableCups += readLine()!!.toInt()
    }

    private fun take() {
        println("I gave you $$money")
        money = 0
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        val input = readLine()!!
        coffeeMachine.processInput(input)
        println()
        if (input == "exit") break
    }
}
