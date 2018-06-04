package com.example.testaccount.basementsandandroids3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testaccount.basementsandandroids3.R.id.button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, DMActivity::class.java)
            startActivity(intent)
        }
    }
}
