package com.example.l4_homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val etPfLog = findViewById<EditText>(R.id.etProfLogin)
        val etPfPass = findViewById<EditText>(R.id.etProfPass)
        val btUpdate = findViewById<Button>(R.id.btnUpdate)
        val btExit = findViewById<Button>(R.id.btnExit)

        val pref = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val textLog = pref.getString("login"," ")
        val textPass = pref.getString("password","no ")
        etPfLog.setText(textLog)
        etPfPass.setText(textPass)

        btUpdate.setOnClickListener {
            val txtProfLog = etPfLog.text.toString()
            val txtProfPass = etPfPass.text.toString()
            pref.edit().putString("login", txtProfLog).apply()
            pref.edit().putString("password", txtProfPass).apply()

            Toast.makeText(applicationContext, "Data updated" , Toast.LENGTH_LONG).show()
        }

        btExit.setOnClickListener {
            val textLog = etPfLog.text.toString()
            val  textPass = etProfPass.text.toString()
            pref.edit().putString("login", textLog).apply()
            pref.edit().putString("password", textPass).apply()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}