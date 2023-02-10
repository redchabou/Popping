class Ninja (var name: String, var health: Int, var attack: Int, var defence: Int, var specialPower: String) {

    fun attack(target: Monster) {
        println("$name is attacking ${target.name} with an attack power of $attack")
        target.health -= attack
        println("${target.name}'s health is now ${target.health}")
    }

    fun useSpecialPower(target: Monster) {
        println("$name is using the special power: $specialPower")
        target.health -= (attack + 30)
        println("${target.name}'s health is now ${target.health}")
    }

//    fun protect(target: Monster) {
//        target.health = (defence + 55)
//        println("$name is using defence power of ${health - defence}")
//    }

    fun healing() {
        health += 100
        println("$name has healed and now has health $health")
    }
}