package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class thirdActivity : AppCompatActivity() {
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        title = "긴급 민원 연락망"
        btn1 = findViewById(R.id.call_120)
        btn2 = findViewById(R.id.call_121)
        btn3 = findViewById(R.id.call_123)
        btn4 = findViewById(R.id.call_1588_2504)

        btn1.setOnClickListener {
            var uri = Uri.parse("tel:120")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            var uri = Uri.parse("tel:121")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            var uri = Uri.parse("tel:123")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            var uri = Uri.parse("tel:1588-2504")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
    }
}