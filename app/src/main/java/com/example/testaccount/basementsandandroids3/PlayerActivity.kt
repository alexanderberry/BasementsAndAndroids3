package com.example.testaccount.basementsandandroids3

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.ImageButton
import android.widget.PopupMenu
import com.example.testaccount.basementsandandroids3.network.NetworkHelper
import com.example.testaccount.basementsandandroids3.network.player.*
import kotlinx.android.synthetic.main.activity_player.*
import kotlinx.coroutines.experimental.launch
import org.json.JSONObject


class PlayerActivity : AppCompatActivity(), View.OnClickListener {
    var pxPos : Int = 0
    var pyPos : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val networkHelper = NetworkHelper("")

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        val imageButton7 = findViewById<ImageButton>(R.id.imageButton7)
        val imageButton8 = findViewById<ImageButton>(R.id.imageButton8)
        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        val imageButton10 = findViewById<ImageButton>(R.id.imageButton10)
        val imageButton11 = findViewById<ImageButton>(R.id.imageButton11)
        val imageButton12 = findViewById<ImageButton>(R.id.imageButton12)
        val imageButton13 = findViewById<ImageButton>(R.id.imageButton13)
        val imageButton14 = findViewById<ImageButton>(R.id.imageButton14)
        val imageButton15 = findViewById<ImageButton>(R.id.imageButton15)
        val imageButton16 = findViewById<ImageButton>(R.id.imageButton16)
        val playerLeft = findViewById<Button>(R.id.playerLeft)
        val playerUp = findViewById<Button>(R.id.playerUp)
        val playerDown = findViewById<Button>(R.id.playerDown)
        val playerRight = findViewById<Button>(R.id.playerRight)

        networkHelper.connect()

        launch {
            networkHelper.joinAsPlayer("TestRoom") {
                when (it) {
                    is PlayerGameStateUpdate -> { //updates game state
                        val array = it.gameState.getJSONArray("players")
                        val gameModel : JSONObject = array[0] as JSONObject
                        pxPos = gameModel.get("x") as Int
                        pyPos = gameModel.get("y") as Int
                        for (x in 0 until array.length()-1){
                            val gameModel : JSONObject = array[x] as JSONObject
                            val xPos = gameModel.get("x")
                            val yPos = gameModel.get("y")
                            if(yPos==1){
                                if(xPos==1){
                                    imageButton.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if(xPos==2){
                                    imageButton2.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if (xPos==3){
                                    imageButton3.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else {
                                    imageButton4.setImageDrawable(R.drawable.barbarian as Drawable)
                                }
                            }else if(yPos==2){
                                if(xPos==1){
                                    imageButton5.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if(xPos==2){
                                    imageButton6.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if (xPos==3){
                                    imageButton7.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else {
                                    imageButton8.setImageDrawable(R.drawable.barbarian as Drawable)
                                }
                            }else if (yPos==3){
                                if(xPos==1){
                                    imageButton9.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if(xPos==2){
                                    imageButton10.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if (xPos==3){
                                    imageButton11.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else {
                                    imageButton12.setImageDrawable(R.drawable.barbarian as Drawable)
                                }
                            }else{
                                if(xPos==1){
                                    imageButton13.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if(xPos==2){
                                    imageButton14.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else if (xPos==3){
                                    imageButton15.setImageDrawable(R.drawable.barbarian as Drawable)
                                }else {
                                    imageButton16.setImageDrawable(R.drawable.barbarian as Drawable)
                                }
                            }
                        }
                        val array2 = it.gameState.getJSONArray("enemies")
                        for (x in 0 until array2.length()-1){
                            val gameModel : JSONObject = array2[x] as JSONObject
                            val xPos = gameModel.get("x")
                            val yPos = gameModel.get("y")
                            if(yPos==1){
                                if(xPos==1){
                                    imageButton.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if(xPos==2){
                                    imageButton2.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if (xPos==3){
                                    imageButton3.setImageDrawable(R.drawable.enemy as Drawable)
                                }else {
                                    imageButton4.setImageDrawable(R.drawable.enemy as Drawable)
                                }
                            }else if(yPos==2){
                                if(xPos==1){
                                    imageButton5.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if(xPos==2){
                                    imageButton6.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if (xPos==3){
                                    imageButton7.setImageDrawable(R.drawable.enemy as Drawable)
                                }else {
                                    imageButton8.setImageDrawable(R.drawable.enemy as Drawable)
                                }
                            }else if (yPos==3){
                                if(xPos==1){
                                    imageButton9.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if(xPos==2){
                                    imageButton10.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if (xPos==3){
                                    imageButton11.setImageDrawable(R.drawable.enemy as Drawable)
                                }else {
                                    imageButton12.setImageDrawable(R.drawable.enemy as Drawable)
                                }
                            }else{
                                if(xPos==1){
                                    imageButton13.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if(xPos==2){
                                    imageButton14.setImageDrawable(R.drawable.enemy as Drawable)
                                }else if (xPos==3){
                                    imageButton15.setImageDrawable(R.drawable.enemy as Drawable)
                                }else {
                                    imageButton16.setImageDrawable(R.drawable.enemy as Drawable)
                                }
                            }
                        }
                    }
                    is TurnChangeSelf -> { //Is our turn now
                        playerDown.isEnabled = true
                        playerLeft.isEnabled = true
                        playerRight.isEnabled = true
                        playerUp.isEnabled = true
                    }
                    is TurnChangeOther -> { //not allowed to move
                        it.gameState
                        playerDown.isEnabled = false
                        playerLeft.isEnabled = false
                        playerRight.isEnabled = false
                        playerUp.isEnabled = false
                    }
                    is OtherPlayerConnectionChange -> { //
                        it.isTurn
                    }
                    is StartGame -> { //start
                        it.gameState
                    }
                    is PlayerGameEnd -> { //stop
                        it.gameState
                    }
                }
            }
        }
    }

    override fun onClick(v: View?) {//1-4
        if(v == playerDown){
            if(pyPos!=4){
                if(pyPos==1){
                    if(pxPos==1){
                        imageButton.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton2.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton3.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton4.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if(pyPos==2){
                    if(pxPos==1){
                        imageButton5.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton6.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton7.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton8.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if (pyPos==3){
                    if(pxPos==1){
                        imageButton9.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton10.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton11.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton12.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else{
                    if(pxPos==1){
                        imageButton13.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton14.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton15.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton16.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }
            pyPos+=1
            if(pyPos!=4) {
                if (pyPos == 1) {
                    if (pxPos == 1) {
                        imageButton.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton2.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton3.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton4.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else if (pyPos == 2) {
                    if (pxPos == 1) {
                        imageButton5.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton6.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton7.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton8.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else if (pyPos == 3) {
                    if (pxPos == 1) {
                        imageButton9.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton10.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton11.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton12.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else {
                    if (pxPos == 1) {
                        imageButton13.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton14.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton15.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton16.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                }
            }
            }
        }else if(v == playerUp){
            if(pyPos!=1){
                if(pyPos==1){
                    if(pxPos==1){
                        imageButton.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton2.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton3.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton4.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if(pyPos==2){
                    if(pxPos==1){
                        imageButton5.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton6.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton7.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton8.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if (pyPos==3){
                    if(pxPos==1){
                        imageButton9.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton10.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton11.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton12.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else{
                    if(pxPos==1){
                        imageButton13.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton14.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton15.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton16.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }
            pyPos-=1
            if(pyPos!=4) {
                if (pyPos == 1) {
                    if (pxPos == 1) {
                        imageButton.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton2.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton3.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton4.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else if (pyPos == 2) {
                    if (pxPos == 1) {
                        imageButton5.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton6.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton7.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton8.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else if (pyPos == 3) {
                    if (pxPos == 1) {
                        imageButton9.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton10.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton11.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton12.setImageDrawable(R.drawable.barbarian as Drawable)
                    }
                } else {
                    if (pxPos == 1) {
                        imageButton13.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 2) {
                        imageButton14.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else if (pxPos == 3) {
                        imageButton15.setImageDrawable(R.drawable.barbarian as Drawable)
                    } else {
                        imageButton16.setImageDrawable(R.drawable.barbarian as Drawable)
                    }

                }
            }
            }
        }else if(v == playerLeft){
            if(pxPos!=1){
                if(pyPos==1){
                    if(pxPos==1){
                        imageButton.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton2.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton3.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton4.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if(pyPos==2){
                    if(pxPos==1){
                        imageButton5.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton6.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton7.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton8.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if (pyPos==3){
                    if(pxPos==1){
                        imageButton9.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton10.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton11.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton12.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else{
                    if(pxPos==1){
                        imageButton13.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton14.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton15.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton16.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }
                pxPos-=1
                if(pyPos!=4) {
                    if (pyPos == 1) {
                        if (pxPos == 1) {
                            imageButton.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton2.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton3.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton4.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else if (pyPos == 2) {
                        if (pxPos == 1) {
                            imageButton5.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton6.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton7.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton8.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else if (pyPos == 3) {
                        if (pxPos == 1) {
                            imageButton9.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton10.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton11.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton12.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else {
                        if (pxPos == 1) {
                            imageButton13.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton14.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton15.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton16.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    }
                }
            }

        }else if(v == playerRight){
            if(pxPos!=4){
                if(pyPos==1){
                    if(pxPos==1){
                        imageButton.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton2.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton3.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton4.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if(pyPos==2){
                    if(pxPos==1){
                        imageButton5.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton6.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton7.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton8.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else if (pyPos==3){
                    if(pxPos==1){
                        imageButton9.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton10.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton11.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton12.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }else{
                    if(pxPos==1){
                        imageButton13.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if(pxPos==2){
                        imageButton14.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else if (pxPos==3){
                        imageButton15.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }else {
                        imageButton16.setImageDrawable(R.mipmap.ic_launcher as Drawable)
                    }
                }
                pxPos+=1
                if(pyPos!=4) {
                    if (pyPos == 1) {
                        if (pxPos == 1) {
                            imageButton.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton2.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton3.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton4.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else if (pyPos == 2) {
                        if (pxPos == 1) {
                            imageButton5.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton6.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton7.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton8.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else if (pyPos == 3) {
                        if (pxPos == 1) {
                            imageButton9.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton10.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton11.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton12.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    } else {
                        if (pxPos == 1) {
                            imageButton13.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 2) {
                            imageButton14.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else if (pxPos == 3) {
                            imageButton15.setImageDrawable(R.drawable.barbarian as Drawable)
                        } else {
                            imageButton16.setImageDrawable(R.drawable.barbarian as Drawable)
                        }
                    }
                }
            }
        }
    }
}
