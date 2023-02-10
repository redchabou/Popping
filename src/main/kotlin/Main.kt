fun greeting(){
    println("\u001B[32m Welcome in my Abschlussprojekt \u001B[0m")
    println(" ")
    println("This is an easy \uD83D\uDC64 Ninjas Game \uD83D\uDC64!")
    Thread. sleep(1500)
    println("You are facing \uD83D\uDC79 the Monster \uD83D\uDC79 with your three Ninjas.")
    Thread. sleep(1500)
    println("You have 3 Actions.")
    Thread. sleep(1500)
    println("try to use them wisely to win.")
    Thread. sleep(1500)
    println("The battle begins in few seconds.")
    Thread. sleep(3000)
}

fun main() {
    val ninjas = listOf(
    Ninja(" ❌ Red Ninja ❌", 120, 35, 36, "Fireball"),
    Ninja("\uD83D\uDD35 Blue Ninja \uD83D\uDD35", 120, 42, 26, "Iceball"),
    Ninja("\uD83D\uDFE1 Yellow Ninja \uD83D\uDFE1", 120, 36, 25, "Windball"))

    val monster = Monster("\uD83D\uDC79 Monster \uD83D\uDC79", 300, 35, 30, "Hit with a Big Hammer")
    greeting()
    var turn = 0
    val startTime = System.currentTimeMillis()
    while (ninjas.any { it.health > 0 } && monster.health > 0) {
        val ninja = ninjas[turn % ninjas.size]
        if (ninja.health <= 0) {
            turn++
            continue
        }
            println("What would you like from the ${ninja.name} to do?")
            println(" ")
            println("1. Attack")
            println("2. Healing")
            println("3. Use special power")
//            println("4. Protect")
            print("Enter your choice: ")
            println(" ")

            var action = readLine()!!.toInt()
            while (action !in 1..3) {
                println("Invalid choice. Please enter a number between 1 and 3.")
                action = readLine()!!.toInt()
            }
            Thread. sleep(2000)

            when (action) {

                1 -> ninja.attack(monster)
                2 -> ninja.healing()
                3 -> ninja.useSpecialPower(monster)
//                4 -> ninja.protect(monster)
                else -> {
                    println("Please enter the right Choice: ")
                    turn--
                }

            }
            if (monster.health <= 0) {
                break
            }
            monster.attack(ninja)
            monster.useSpecialPower(ninja)

        }
        if (ninjas.all { it.health <= 0 }) {
            println("\u001B[31m GameOver! \u001B[0m")
            println("\u001B[31m All Ninjas are defeated! \u001B[0m")
            println(""" [31m
____________________
||                 ||
||   You Lose!     ||
||_________________||
[0m
""")
        } else {
            println("\u001B[32m Great Job! \u001B[0m")
            println("\u001B[31m The Monster is eliminated. \u001B[0m")
            println(""" [32m
____________________
||                ||
||   You Win!     ||
||________________||
[0m
""")
        }
    val endTime = System.currentTimeMillis()
    val playtime = (endTime - startTime) / 1000
    println("\u001B[32m Playtime: $playtime seconds \u001B[0m")
}




