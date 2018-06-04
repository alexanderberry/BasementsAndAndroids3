package com.example.testaccount.basementsandandroids3.network.dm

import android.util.Log
import com.example.testaccount.basementsandandroids3.network.json
import io.socket.client.Socket
import org.json.JSONObject

class DMController(private val socket: Socket, private val callback: (DMGameStateChange) -> Unit) {

    init {
        configSocketEvents()
    }

    private fun configSocketEvents(): Unit = with(socket) {
        on(Socket.EVENT_CONNECT) {
            Log.d("asdf","Connected")
        }
        on("PlayerConnectedChange") {
            val json = it[0] as JSONObject
            Log.d("asdf", "Player Connected, ID: ${json.getInt("id")}")
            callback(PlayerConnectionChange(true, json.getInt("id")))
        }
        on("PlayerDisconnectedChange") {
            val json = it[0] as JSONObject
            Log.d("asdf", "Player Disconnected, ID: ${json.getInt("id")}")
            callback(PlayerConnectionChange(false, json.getInt("id")))
        }
        on("SocketID") {
            val json = it[0] as JSONObject
            Log.d("asdf", "My ID: ${json.getInt("id")}")
        }
        //custom events
        on("DMGameStateUpdate") {
            val json = it[0] as JSONObject
            callback(DMGameStateUpdate(json.getJSONObject("gameState")))
        }
        on("PlayerTurnChange") {
            val json = it[0] as JSONObject
            callback(PlayerTurnChange(json.getJSONObject("gameState"), json.getInt("x"), json.getInt("y")))
        }
        on("EnemyTurnChange") {
            val json = it[0] as JSONObject
            callback(EnemyTurnChange(json.getJSONObject("gameState")))
        }
        on("GameEnd") {
            val json = it[0] as JSONObject
            callback(DMGameEnd(json.getJSONObject("gameState")))
        }
    }

    fun updateGameState(gameState: JSONObject) {
        socket.emit("updateGameStateAsDM", json("gameState" to gameState.toString()))
    }

    fun nextTurn() {
        socket.emit("NextTurn")
    }

    fun startGame() {
        socket.emit("StartGame")
    }
}