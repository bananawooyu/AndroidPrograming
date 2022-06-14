package com.example.myproject

import android.content.Intent
import android.location.*
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var emergencyBtn : ImageButton
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var adText : TextView

    //latitute : 37.361340 , Longtitute : 127.956344 == 내집
    lateinit var address : String
    var lat = 37.305659
    var lng = 127.921642

    lateinit var smsText : String

    private fun getCurrentLocation() {
        LocationHelper().startListeningUserLocation(this , object : LocationHelper.MyLocationListener {
            override fun onLocationChanged(location: Location) {
                // Here you got user location :)
                Log.d("Location","" + location.latitude + "," + location.longitude)
                lat = location.latitude
                lng = location.longitude
                //Toast.makeText(this@MainActivity, "Latitute : ${lat} / Longtitute : ${lng}", Toast.LENGTH_LONG).show()
                var geo  = Geocoder(applicationContext, Locale.getDefault())
                var Result : List<Address>? = null
                try {
                    Result = geo.getFromLocation(lat!!, lng!!, 1)
                }catch (e : IOException){
                    e.printStackTrace()
                }

                if (Result != null){
                    address = Result[0].getAddressLine(0)
                    //address = address.substring(4)
                    adText.setText(address)
                    smsText = "긴급 구조가 필요합니다" + "\n" + address
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.app_name)
        btn1 = findViewById(R.id.fst)
        btn2 = findViewById(R.id.sec)
        btn3 = findViewById(R.id.thd)
        btn4 = findViewById(R.id.fth)
        emergencyBtn = findViewById(R.id.sosBtn)
        adText = findViewById(R.id.addressText)

        getCurrentLocation()

        var intent : Intent
        var smsNum = "112"

        btn1.setOnClickListener {
            intent = Intent(this, firstActivity::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            intent = Intent(this, secondActivity::class.java)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            intent = Intent(this, thirdActivity::class.java)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            intent = Intent(this, forthActivity::class.java)
            startActivity(intent)
        }

        emergencyBtn.setOnClickListener {
            var smsUri : Uri = Uri.parse("sms:"+smsNum)
            var intent1 = Intent(Intent.ACTION_SENDTO, smsUri)
            intent1.putExtra("sms_body",smsText)
            startActivity(intent1)
        }

    }
}