package com.example.threadingexercises

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.threadingexercises.service.MyServiceExample
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_service_example.buttonNext
import kotlinx.android.synthetic.main.activity_service_example.buttonStart
import kotlinx.android.synthetic.main.activity_service_example.buttonStop

class ServiceExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_example)
        setSupportActionBar(toolbar)

        buttonStart.setOnClickListener{
            startService(Intent(this, MyServiceExample::class.java))
        }

        buttonStop.setOnClickListener{
            stopService(Intent(this, MyServiceExample::class.java))
        }

        buttonNext.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
