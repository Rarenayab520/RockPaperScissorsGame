package com.nayab.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val choices = arrayOf("rock", "paper", "scissors")
    private var userScore = 0
    private var computerScore = 0

    private lateinit var userScoreText: TextView
    private lateinit var computerScoreText: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockImage = findViewById<ImageView>(R.id.rockImage)
        val paperImage = findViewById<ImageView>(R.id.paperImage)
        val scissorsImage = findViewById<ImageView>(R.id.scissorsImage)

        userScoreText = findViewById(R.id.userScoreText)
        computerScoreText = findViewById(R.id.computerScoreText)
        resultText = findViewById(R.id.resultText)

        rockImage.setOnClickListener { play("rock") }
        paperImage.setOnClickListener { play("paper") }
        scissorsImage.setOnClickListener { play("scissors") }
    }

    private fun play(userChoice: String) {
        val computerChoice = choices.random()

        val result = when {
            userChoice == computerChoice -> "It's a draw!"
            userChoice == "rock" && computerChoice == "scissors" ||
                    userChoice == "paper" && computerChoice == "rock" ||
                    userChoice == "scissors" && computerChoice == "paper" -> {
                userScore++
                "🎉 You win!"
            }
            else -> {
                computerScore++
                "😢 Computer wins!"
            }
        }

        resultText.text = "You chose: $userChoice\nComputer chose: $computerChoice\n$result"
        userScoreText.text = "Your Score: $userScore"
        computerScoreText.text = "Computer Score: $computerScore"
    }
}
