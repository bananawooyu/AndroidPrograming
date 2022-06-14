package com.example.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class forthActivity : AppCompatActivity() {
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forth)

        title = "긴급 민원 연락망"
        btn1 = findViewById(R.id.call_1330)

        btn1.setOnClickListener {
            var uri = Uri.parse("tel:1330")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
    }
}