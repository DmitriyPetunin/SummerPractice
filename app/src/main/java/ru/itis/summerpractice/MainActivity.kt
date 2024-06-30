package ru.itis.summerpractice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.edit_text1)
        val button = findViewById<Button>(R.id.buttonRace)
        button.setOnClickListener{
            val inputValue = editText.text.toString()
            val count = inputValue.toInt()
            val list = createListOfCars(count)
            Log.i("Teg","$list")
            globalRace(list)
            Toast.makeText(this, "${list}", Toast.LENGTH_LONG).show()
        }
    }
    private fun createListOfCars(count:Int): ArrayList<Car> {
        val listOfMarks = listOf("Tayota", "Honda", "Nissan", "Lamborghini", "Aston Martin", "Bentley")
        val listOfModels = listOf("Rav4", "Civic", "Skyline", "Huracan", "DBX", "Bentayga")
        val listOfCars = ArrayList<Car>(count)
        for (i in 1..count) {
            val year = Random.nextInt(1980, 2024)
            val car = Builder("car $i")
                .setMark(listOfMarks.random())
                .setModel(listOfModels.random())
                .setYear(year)
                .build()
            listOfCars.add(car)
        }
        return listOfCars
    }
    private fun globalRace(listCars : ArrayList<Car>) {
        var winners = listCars
        while (winners.size > 1){
             winners = lap(winners)
        }
        Log.i("victory","Победитель гонки $winners")
    }

    private fun lap(cars : ArrayList<Car>): ArrayList<Car>{
        var winners = ArrayList<Car>()
        while (cars.isNotEmpty()){
            if (cars.size == 1) {
                winners.addAll(cars)
                Log.i("race","Нет пар, следующий круг")
                break
            } else {
                val index1 = Random.nextInt(0,cars.size)
                var index2 = Random.nextInt(0,cars.size)
                while (index2 == index1) {
                    index2 = Random.nextInt(0, cars.size)
                }
                val car1 = cars.get(index1)
                val car2 = cars.get(index2)
                val winner = car1.race(car2)
                winners.add(winner)
                Log.i("race","Гонка между ${car1} и ${car2}, Победитель круга ${winner})}")
                cars.remove(car1)
                cars.remove(car2)
            }
        }
        return winners
    }
}