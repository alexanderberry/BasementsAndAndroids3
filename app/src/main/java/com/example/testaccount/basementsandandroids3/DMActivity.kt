package com.example.testaccount.basementsandandroids3

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import android.widget.PopupMenu

import kotlinx.android.synthetic.main.activity_game.*

class DMActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        imageButton.setOnClickListener(this)
        imageButton11.setOnClickListener(this)
        imageButton12.setOnClickListener(this)
        imageButton13.setOnClickListener(this)
        imageButton14.setOnClickListener(this)
        imageButton15.setOnClickListener(this)
        imageButton16.setOnClickListener(this)
        imageButton17.setOnClickListener(this)
        imageButton18.setOnClickListener(this)
        imageButton19.setOnClickListener(this)
        imageButton20.setOnClickListener(this)
        imageButton21.setOnClickListener(this)
        imageButton22.setOnClickListener(this)
        imageButton2.setOnClickListener(this)
        imageButton5.setOnClickListener(this)
        imageButton6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val popup = PopupMenu(this, imageButton)
        popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            imageButton.setImageDrawable(it.icon)
            true
        }
        popup.show()
    }
}
