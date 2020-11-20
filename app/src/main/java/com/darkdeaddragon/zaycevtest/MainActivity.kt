package com.darkdeaddragon.zaycevtest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mSharedPref = getSharedPreferences("main",MODE_PRIVATE)
        var startTimes = mSharedPref.getInt("start_times", 0)
        val mEditor = mSharedPref.edit()
        mEditor.putInt("start_times", ++startTimes)
        mEditor.apply()
        if (startTimes == 3) Toast.makeText(applicationContext, "Time to feed your turtle!", Toast.LENGTH_SHORT).show()
    }

    fun nullifierClick(view: View) {
        val mEditor = getSharedPreferences("main",MODE_PRIVATE).edit()
        mEditor.putInt("start_times", 0)
        mEditor.apply()
    }

}