class Monster(var name: String, var health: Int, var attack: Int, var defence: Int, var specialPower: String) {

    fun attack(target: Ninja) {
        println("$name is attacking ${target.name} with an attack power of $attack")
        target.health -= attack
        println("${target.name}'s health is now ${target.health}")
    }

    fun useSpecialPower(target: Ninja) {
        println("$name is using the special power: $specialPower")
        target.health -= (attack + 5)
        println("${target.name}'s health is now ${target.health}")
    }
}