package com.example.k_vi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class sk : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var option1Button: RadioButton
    private lateinit var option2Button: RadioButton
    private lateinit var option3Button: RadioButton
    private lateinit var option4Button: RadioButton
    private lateinit var nextButton: Button
    private lateinit var RadioGroup : RadioGroup

    private lateinit var CongratilationTextView: TextView
    private lateinit var TextView: TextView


    private val questions = listOf(
        "Вопрос 1: Сколько мемберов в группе?",
        "Вопрос 2: Название дебютной песни?",
        "Вопрос 3: В каком году дебютировали?",
        "Вопрос 4: Кто лидер группы?",
        "Вопрос 5: Сценическое имя лидера группы?",
        "Вопрос 6: Сколько кошек у Минхо?",
        "Вопрос 7: Самый младший участник?",
    )

    private val options = listOf(
        listOf("8", "18", "7", "82"),
        listOf("district9", "god`s menu", "hellevator", "s-class"),
        listOf("2018", "2019", "2022", "1830"),
        listOf("Банчан", "Сынмин", "Чонин", "Минхо"),
        listOf("CB97, Кристофер Бан, Бан Чан", "ЧанЧан", "ЧакЧак", "Старый"),
        listOf("3", "2", "5", "10"),
        listOf("Чонин", "Сынмин", "Банчан", "Феликс"),
    )

    private var currentQuestionIndex = 0
    private var userScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sk)

        questionTextView = findViewById(R.id.textView12)
        option1Button = findViewById(R.id.button2)
        option2Button = findViewById(R.id.button3)
        option3Button = findViewById(R.id.button4)
        option4Button = findViewById(R.id.button5)
        nextButton = findViewById(R.id.button6)
        RadioGroup = findViewById(R.id.radioGroup)

        TextView = findViewById(R.id.textView14)
        CongratilationTextView = findViewById(R.id.textView13)


        updateQuestion()

        option1Button.setOnClickListener { checkAnswer(0) }
        option2Button.setOnClickListener { checkAnswer(1) }
        option3Button.setOnClickListener { checkAnswer(2) }
        option4Button.setOnClickListener { checkAnswer(3) }
        nextButton.setOnClickListener { nextQuestion() }
    }

    private fun updateQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        option1Button.text = options[currentQuestionIndex][0]
        option2Button.text = options[currentQuestionIndex][1]
        option3Button.text = options[currentQuestionIndex][2]
        option4Button.text = options[currentQuestionIndex][3]

        enableOptions()
    }

    private fun checkAnswer(selectedOption: Int) {
        if (selectedOption == getCorrectAnswerIndex()) {
            userScore++
        }
        disableOptions()
    }

    private fun nextQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            updateQuestion()
        } else {
            // Показать результат в конце викторины
            showResult()
        }
    }

    private fun showResult() {
        questionTextView.text = "Ваш результат: $userScore из ${questions.size}"
        option1Button.visibility = View.GONE
        option2Button.visibility = View.GONE
        option3Button.visibility = View.GONE
        option4Button.visibility = View.GONE
        RadioGroup.visibility = View.INVISIBLE
        CongratilationTextView.visibility = View.VISIBLE
        nextButton.setOnClickListener {
            nextButton.text = "В начало"
            val intent : Intent =   Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if (userScore >= 5){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас высокий балл, вы отлично \n" +
                    "знаете STRAY KIDS! Продолжайте в том же темпе)"

        }
        else if (userScore == 3 || userScore == 4){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас средний балл, вы хорошо \n" +
                    "знаете STRAY KIDS! Продолжайте в том же темпе и достигните большего)"
        }
        else if (userScore == 0 || userScore == 1 || userScore == 2){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас низкий балл, вы плохо \n" +
                    "знаете STRAY KIDS! Но не расстраивайтесь, главное не останавливаться))"
        }
    }
    private fun getCorrectAnswerIndex(): Int {
        return 0
    }

    private fun disableOptions() {
        option1Button.isEnabled = false
        option2Button.isEnabled = false
        option3Button.isEnabled = false
        option4Button.isEnabled = false


    }

    private fun enableOptions() {
        option1Button.isEnabled = true
        option2Button.isEnabled = true
        option3Button.isEnabled = true
        option4Button.isEnabled = true

        if (option1Button.isChecked){
            option1Button.isChecked = true

        }
        else if (option2Button.isChecked){
            option2Button.isChecked = true

        }
        else if (option3Button.isChecked){
            option3Button.isChecked = true

        }
        else if (option4Button.isChecked){
            option4Button.isChecked = true
        }
        else{
            option1Button.isChecked = false
            option2Button.isChecked = false
            option3Button.isChecked = false
            option4Button.isChecked = false

        }
    }
}