package com.example.testaccount.basementsandandroids3.model

import android.widget.ImageButton

data class GameModel(var x: Int, var y: Int, var health: Int, var initiative: Int) {
    constructor(): this(0,0,0,0)
}