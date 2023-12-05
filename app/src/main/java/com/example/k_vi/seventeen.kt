package com.example.k_vi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class seventeen : AppCompatActivity() {
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
        "Вопрос 1: С какой группой изначально должен был дебютировать S.Coups?",
        "Вопрос 2: На каком шоу Джонхан выступал в качестве судьи?",
        "Вопрос 3: Как Джошуа представил себя на шоу Weekly Idol?",
        "Вопрос 4: За что Джун в детстве получал множество медалей?",
        "Вопрос 5: Большим фанатом какой к-поп группы является Хоши?",
        "Вопрос 6: От какого корейского фильма всегда плачет Вону?",
        "Вопрос 7: С кем в одной комнате жил Уджи в старом общежитии группы?",
    )

    private val options = listOf(
        listOf("NU’EST",
            "IKON",
            "MONSTA X",
            "DAY6"),

        listOf("King of Mask Singer",
            "I-Land",
            "Kingdom: Legendary War",
            "Loud"),

        listOf("как участник, говорящий на 5 языках",
            "как участник, родившийся в Сеуле",
            "как участник, который никогда не смотрел аниме",
            "как участник, способный повторить любой танец"),

        listOf("за боевые искусства",
            "за вокал",
            "за актерскую карьеру",
            "за олимпиады по математике"),

        listOf("SHINee",
            "Super Junior",
            "2NE1",
            "ATEEZ"),

        listOf("Чудо в камере №7",
            "Битва за Мён Рян",
            "Сочувствие госпоже Месть",
            "Ода моему отцу\n"),

        listOf("Мингю",
            "Сынкван",
            "Дино",
            "Миён"),
    )

    private var currentQuestionIndex = 0
    private var userScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventeen)

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
                    "знаете SEVENTEEN! Продолжайте в том же темпе)"

        }
        else if (userScore == 3 || userScore == 4){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас средний балл, вы хорошо \n" +
                    "знаете SEVENTEEN! Продолжайте в том же темпе и достигните большего)"
        }
        else if (userScore == 0 || userScore == 1 || userScore == 2){
            TextView.visibility = View.VISIBLE
            TextView.text = "У вас низкий балл, вы плохо \n" +
                    "знаете SEVENTEEN! Но не расстраивайтесь, главное не останавливаться))"
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