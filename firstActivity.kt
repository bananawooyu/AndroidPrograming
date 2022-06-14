package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class firstActivity : AppCompatActivity() {
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first)

        title = "긴급 민원 연락망"
        btn1 = findViewById(R.id.call_112)
        btn2 = findViewById(R.id.call_117)
        btn3 = findViewById(R.id.call_118)
        btn4 = findViewById(R.id.call_122)

        btn1.setOnClickListener {
            var uri = Uri.parse("tel:112")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            var uri = Uri.parse("tel:117")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            var uri = Uri.parse("tel:118")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            var uri = Uri.parse("tel:122")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
    }
}