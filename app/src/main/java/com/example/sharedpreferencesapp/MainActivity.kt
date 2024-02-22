package com.example.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit: EditText = findViewById(R.id.edit)
        val btn: Button = findViewById(R.id.btn)
        name =findViewById(R.id.last)

        DisplaySavedText()

        btn.setOnClickListener(){
            val enteredText: String = edit.text.toString()
            SaveNameInSharedPref(enteredText)

        }
    }

    private fun SaveNameInSharedPref(enteredText: String) {
        //Saving text into shared preferences
        val sharedPreferences :SharedPreferences = getSharedPreferences("UserName", MODE_PRIVATE)

        //Writing data to shared preferences
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("name", enteredText)
        editor.commit()

    }

    //Reading data from shared pref
    fun DisplaySavedText(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserName", MODE_PRIVATE)
        val s1: String? = sharedPreferences.getString("name", "")
        name.text = s1
    }
}