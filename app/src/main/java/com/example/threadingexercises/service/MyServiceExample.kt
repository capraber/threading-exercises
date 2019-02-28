package com.example.threadingexercises.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.example.threadingexercises.R

class MyServiceExample : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Toast.makeText(this, getString(R.string.service_created), Toast.LENGTH_SHORT).show()
        // use R.raw.drum_sound_effect for the sound
        // Set looping to true
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, getString(R.string.service_started), Toast.LENGTH_SHORT).show()
        return Service.START_NOT_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(this, getString(R.string.service_stopped), Toast.LENGTH_SHORT).show()
    }
}
