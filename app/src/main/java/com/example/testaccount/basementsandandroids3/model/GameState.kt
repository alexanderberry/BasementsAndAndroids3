package com.example.testaccount.basementsandandroids3.model

/**
 * Created by testaccount on 6/4/18.
 */
data class GameState(var players: Array<GameModel>, var enemies: Array<GameModel>){
    constructor(): this(emptyArray(), emptyArray())
}