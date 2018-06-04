package com.example.testaccount.basementsandandroids3

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.PopupMenu
import com.example.testaccount.basementsandandroids3.network.NetworkHelper

import kotlinx.android.synthetic.main.activity_game.*

class DMActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        imageButton.setOnClickListener(this)
        imageButton.tag = imageButton
        imageButton5.setOnClickListener(this)
        imageButton5.tag = imageButton5
        imageButton7.setOnClickListener(this)
        imageButton7.tag = imageButton7
        imageButton6.setOnClickListener(this)
        imageButton6.tag = imageButton6
        imageButton8.setOnClickListener(this)
        imageButton8.tag = imageButton8
        imageButton12.setOnClickListener(this)
        imageButton12.tag = imageButton12
        imageButton11.setOnClickListener(this)
        imageButton11.tag = imageButton11
        imageButton10.setOnClickListener(this)
        imageButton10.tag = imageButton10
        imageButton9.setOnClickListener(this)
        imageButton9.tag = imageButton9
        imageButton13.setOnClickListener(this)
        imageButton13.tag = imageButton13
        imageButton15.setOnClickListener(this)
        imageButton15.tag = imageButton15
        imageButton16.setOnClickListener(this)
        imageButton16.tag = imageButton16
        imageButton14.setOnClickListener(this)
        imageButton14.tag = imageButton14
        imageButton2.setOnClickListener(this)
        imageButton2.tag = imageButton2
        imageButton3.setOnClickListener(this)
        imageButton3.tag = imageButton3
        imageButton4.setOnClickListener(this)
        imageButton4.tag = imageButton4
        val networkHelper = NetworkHelper("") //ip address (hardcoded)
        startgame.setOnClickListener {
            val layout = window.decorView.rootView
        }
    }

    override fun onClick(v: View?) {
        val popup = PopupMenu(this, v?.tag as View)
        popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            val tag = v.tag as ImageButton
            tag.setImageDrawable(it.icon)
            true
        }
        popup.show()
    }
}
