package com.example.practice.secondTask

abstract class Vehicles: SoundAble{
    abstract val volume: Float
}

abstract class Car: Vehicles(), RadioAble{
    abstract val name: String
}

abstract class Motorbike: Vehicles(){
    abstract val name: String
}

class Audi(override val volume: Float, override val name: String) : Car(){
    override fun makeSound() {
        println("audi make sound")
    }

    override fun playRadio() {
        println("radio playing in audi")
    }

    override fun toString(): String {
        return "$name, volume = $volume"
    }
}

class Mercedes(override val volume: Float, override val name: String): Car(){

    override fun makeSound() {
        println("mercedes make sound")
    }

    override fun playRadio() {
        println("radio playing in mercedes")
    }

    override fun toString(): String {
        return "$name, volume = $volume"
    }
}

class Yamaha(override val volume: Float, override val name: String): Motorbike(){

    override fun makeSound() {
        println("yamaha make sound")
    }

    override fun toString(): String {
        return "$name, volume = $volume"
    }
}

class Kawasaki(override val volume: Float, override val name: String): Motorbike(){

    override fun makeSound() {
        println("kawasaki make sound")
    }

    override fun toString(): String {
        return "$name, volume = $volume"
    }
}