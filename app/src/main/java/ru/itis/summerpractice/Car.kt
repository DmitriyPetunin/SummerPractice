package ru.itis.summerpractice

open class Car(
    val mark:String,
    val model:String,
    val year:Int) {

    override fun toString(): String {
        return "Car(mark='$mark', model='$model', year=$year)"
    }
    fun race(car2:Car):Car{
        return if (this.year > car2.year) this else car2
    }
}
