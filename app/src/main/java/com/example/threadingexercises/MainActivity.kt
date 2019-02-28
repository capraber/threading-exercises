package com.example.threadingexercises

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import kotlinx.android.synthetic.main.activity_main.btnLooper
import kotlinx.android.synthetic.main.activity_main.btnService
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btnLooper.setOnClickListener {
            startActivity(Intent(this, ChildThreadHandlerLooperActivity::class.java))
        }

        btnService.setOnClickListener {
            startActivity(Intent(this, ServiceExampleActivity::class.java))
        }
    }
}
