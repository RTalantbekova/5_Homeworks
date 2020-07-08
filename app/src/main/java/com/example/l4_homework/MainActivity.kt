package com.example.l4_homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etLog = findViewById<EditText>(R.id.etLogin)
        val etPass = findViewById<EditText>(R.id.etPassword)

        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)

        btnRegist.setOnClickListener {
            val txtLog = etLog.text.toString()
            val txtPass = etPass.text.toString()

            preference.edit().putString("login", txtLog).apply()
            preference.edit().putString("password", txtPass).apply()

            Toast.makeText(applicationContext, "You are successfully registered", Toast.LENGTH_LONG).show()
        }

        btnLogin.setOnClickListener {
            val txtLogin = etLog.text.toString()
            val txtPassword = etPass.text.toString()

            val LoginFromPref = preference.getString("login","no login")
            val PassFromPref = preference.getString("password", "no password")

            if (LoginFromPref == txtLogin && PassFromPref == txtPassword)
            {
                val intent = Intent(applicationContext, ProfileActivity::class.java)
                startActivity(intent)

            }else
            {
                Toast.makeText(applicationContext, "Login or password not correct", Toast.LENGTH_LONG).show()
            }
        }
    }
}