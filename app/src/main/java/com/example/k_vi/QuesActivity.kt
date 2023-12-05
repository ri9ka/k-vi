package com.example.k_vi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuesActivity : AppCompatActivity() {
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
        "Вопрос 1: Дата дебюта?",
        "Вопрос 2: Кто лидер группы?",
        "Вопрос 3: Как зовут ёжика Субина?",
        "Вопрос 4: Кто вижуал группы?",
        "Вопрос 5: Кто из участников был подтанцовкой V из BTS?",
        "Вопрос 6: Почему Тэхён выбрал Бигхит?",
        "Вопрос 7: ТХТ дебютировала с песней...",
)

    private val options = listOf(
        listOf("04.03.2019", "12.02.2019", "18.03.2020", "13.03.2018"),
        listOf("Субин", "Бомгю", "Намджун", "Тэхён"),
        listOf("Оди", "У него есть ёжик?", "Ёжика-зовут Ёжик, как из смешариков", "Тэхён"),
        listOf("Хюнинкай", "Бомгю", "Енджун", "Тэхён"),
        listOf("Ёнджун", "Бомгю", "Намджун", "Субин"),
        listOf("Потому что, он оказался ближе всех к его дому", "Ему пришлось", "Потому что, ему так захотелось", "Его заставили"),
        listOf("Crown", "Can’t you see me", "Good boy Gone bad", "Run Away\n"),
        )

    private var currentQuestionIndex = 0
    private var userScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ques)

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
                    "знаете TXT! Продолжайте в том же темпе)"

        }
        else if (userScore == 3 || userScore == 4){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас средний балл, вы хорошо \n" +
                    "знаете TXT! Продолжайте в том же темпе и достигните большего)"
        }
        else if (userScore == 0 || userScore == 1 || userScore == 2){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас низкий балл, вы плохо \n" +
                    "знаете TXT! Но не расстраивайтесь, главное не останавливаться))"
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