package com.example.testaccount.basementsandandroids3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerButton.setOnClickListener(::startGamePlayer)
        dmButton.setOnClickListener(::startGameDM)
        monsterButton.setOnClickListener(::viewMonsters)
    }

    private fun startGamePlayer(view: View) {
        val intent = Intent(this, PlayerActivity::class.java)
        startActivity(intent)
    }

    private fun startGameDM(view: View) {
        val intent = Intent(this, DMActivity::class.java)
        startActivity(intent)
    }

    private fun viewMonsters(view: View) {
        val intent = Intent(this, MonsterActivity::class.java)
        startActivity(intent)
    }
}
