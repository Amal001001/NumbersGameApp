package com.example.numbersgameapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import android.util.Log


class MainActivity : AppCompatActivity() {
    lateinit var textview2: TextView
    lateinit var textview3: TextView
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var myLayout: ConstraintLayout
    var counter = 3
    val randomnum = Random.nextInt(11)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLayout = findViewById(R.id.clMain)
        var textview = findViewById<TextView>(R.id.textview)
        textview2 = findViewById(R.id.textview2)
        textview3 = findViewById(R.id.textview3)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)

        textview3.text = "You have $counter guesses"

        button.setOnClickListener {
            //val number = editText.text!!.toString().toInt()
            checking()
        }

    }

    @SuppressLint("SetTextI18n")
    fun checking() {
        var number = editText.text!!.toString()

        if (number != "") {
            if (counter > 0) {
                  if (number.toInt() == randomnum) {
                        textview3.text = "You guessed $number"
                        textview2.text = "correct!"
                  }else {
                       if (number.toInt() > 10 || number.toInt() < 0) {
                        Snackbar.make(myLayout, "wrong range", Snackbar.LENGTH_LONG).show()
                        editText.setText("")}
                       else{
                        counter--
                        textview3.text = "You guessed $number"
                        textview2.text = "You have $counter guesses left"
                        editText.setText("")
                       }
                  }
            }
            if(counter==0){
                textview3.text = "Game Over"
                textview2.text = "the number was $randomnum"
            }
        }

    }
}


