package com.example.testaccount.basementsandandroids3

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu

import kotlinx.android.synthetic.main.activity_game.*

class DMActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        imageButton.setOnClickListener(this)
        imageButton.tag = imageButton
        imageButton11.setOnClickListener(this)
        imageButton11.tag = imageButton11
        imageButton12.setOnClickListener(this)
        imageButton12.tag = imageButton12
        imageButton13.setOnClickListener(this)
        imageButton13.tag = imageButton13
        imageButton14.setOnClickListener(this)
        imageButton14.tag = imageButton14
        imageButton15.setOnClickListener(this)
        imageButton15.tag = imageButton15
        imageButton16.setOnClickListener(this)
        imageButton16.tag = imageButton16
        imageButton17.setOnClickListener(this)
        imageButton17.tag = imageButton17
        imageButton18.setOnClickListener(this)
        imageButton18.tag = imageButton18
        imageButton19.setOnClickListener(this)
        imageButton19.tag = imageButton19
        imageButton20.setOnClickListener(this)
        imageButton20.tag = imageButton20
        imageButton21.setOnClickListener(this)
        imageButton21.tag = imageButton21
        imageButton22.setOnClickListener(this)
        imageButton22.tag = imageButton22
        imageButton2.setOnClickListener(this)
        imageButton2.tag = imageButton2
        imageButton5.setOnClickListener(this)
        imageButton5.tag = imageButton5
        imageButton6.setOnClickListener(this)
        imageButton6.tag = imageButton6
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
