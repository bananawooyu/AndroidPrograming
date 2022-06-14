package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class secondActivity : AppCompatActivity() {
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        title = "긴급 민원 연락망"
        btn1 = findViewById(R.id.call_119)
        btn2 = findViewById(R.id.call_122)

        btn1.setOnClickListener {
            var uri = Uri.parse("tel:119")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            var uri = Uri.parse("tel:122")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

    }
}