package com.example.testaccount.basementsandandroids3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testaccount.basementsandandroids3.network.NetworkHelper
import com.example.testaccount.basementsandandroids3.network.player.*
import kotlinx.coroutines.experimental.launch

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        val networkHelper = NetworkHelper("")
        networkHelper.connect()
        launch {
            networkHelper.joinAsPlayer("TestRoom") {
                when (it) {
                    is PlayerGameStateUpdate -> {
                        it.gameState

                    }
                    is TurnChangeSelf -> {
                        it.gameState
                    }
                    is TurnChangeOther -> {
                        it.gameState
                    }
                    is OtherPlayerConnectionChange -> {
                        it.isTurn
                    }
                    is StartGame -> {
                        it.gameState
                    }
                    is PlayerGameEnd -> {
                        it.gameState
                    }
                }
            }
        }
    }
}
