package com.example.k_vi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val txt : Button = findViewById(R.id.txt)


        txt.setOnClickListener {
            val intent : Intent = Intent(this@CategoryActivity, QuesActivity::class.java)
            startActivity(intent)
        }
    }

    fun skClick(view: View) {
        val intent : Intent = Intent(this@CategoryActivity, sk::class.java)
        startActivity(intent)}

    fun GidleClick(view: View) {
        val intent : Intent = Intent(this@CategoryActivity, gile::class.java)
        startActivity(intent)}

    fun seventeenClick(view: View) {
        val intent : Intent = Intent(this@CategoryActivity, seventeen::class.java)
        startActivity(intent)

    }
}