package ru.itis.summerpractice

class SUV(
    mark: String,
    model: String,
    year: Int,
    val typeMotor: Motors): Car(mark, model, year)