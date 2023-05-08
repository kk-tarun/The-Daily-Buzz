package com.example.thedailybuzz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginPage : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var register:TextView
    private lateinit var loginButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        supportActionBar?.hide()
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val uname = username.text.toString()
            val pass = password.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("username", uname)
            editor.putString("password", pass)
            editor.apply()

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        register = findViewById(R.id.signupText)
        register.setOnClickListener {
            val intent: Intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)
        username.setText(sharedPreferences.getString("username", ""))
        password.setText(sharedPreferences.getString("password", ""))
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}