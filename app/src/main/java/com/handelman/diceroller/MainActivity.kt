package com.handelman.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rollDice()

        }

    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.win_counter)
        var count = 0
        val repetitions = 1000
        repeat(repetitions) {
            win_text.setText("")
            val randomInt = Random().nextInt(6) + 1
            val drawableResource = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            val diceImage: ImageView = findViewById(R.id.dice_image)
            diceImage.setImageResource(drawableResource)

            //val randomInt1 = Random().nextInt(6) +1
            val randomInt1 = (1..6).random()
            val drawableResource1 = when (randomInt1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            val diceImage1: ImageView = findViewById(R.id.dice_image1)
            diceImage1.setImageResource(drawableResource1)
            if (randomInt == randomInt1) ++count

        }
        resultText.text = "Total Wins: $count"
        if ((count.toDouble() / repetitions * 100) > 16.8) win_text.setText("You win the game! You got a dice match percentage of ${count.toDouble() / repetitions * 100}.")
        else win_text.setText("You lose the game! You got a dice match percentage of %${count.toDouble() / repetitions * 100}.")

    }
}

//class MainActivity: AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val rollButton: Button = findViewById(R.id.roll_button)
//        val resultText: TextView = findViewById(R.id.win_text)
//        val die1: ImageView = findViewById(R.id.dice_image)
//        val die2: ImageView = findViewById(R.id.dice_image1)
//
//        rollButton.setOnClickListener {
//            var count = 0
//            val repetitions = 1000
//            repeat(repetitions) {
//                if (rollDie(die1) == rollDie(die2)) ++count
//            }
//            resultText.text = "Percent score: %${count.toDouble() / repetitions * 100}\n Total: $count"
//        }
//    }
//
//    private fun rollDie(image: ImageView): Int {
//        val randInt = (1..6).random()
//        image.setImageResource(when (randInt) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        })
//        return randInt
//    }
//}


//fun doodle () {
//    var x = 4
//    return "${x}"
//}