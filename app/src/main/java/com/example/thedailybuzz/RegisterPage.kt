package com.example.thedailybuzz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterPage : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginText: TextView
    lateinit var registerBtn: Button
    private lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        supportActionBar?.hide()
        loginText = findViewById(R.id.loginText)
        username = findViewById(R.id.username)
        password = findViewById(R.id.registerpassword)
        registerBtn = findViewById(R.id.registerButton)
        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)
        registerBtn.setOnClickListener{
            val uname = username.text.toString()
            val pass = password.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("username", uname)
            editor.putString("password", pass)
            editor.apply()

            val intent : Intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

        loginText.setOnClickListener{
            val intent : Intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
    }
}