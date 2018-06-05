package com.example.testaccount.basementsandandroids3

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ContentFrameLayout
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.PopupMenu
import com.example.testaccount.basementsandandroids3.model.GameModel
import com.example.testaccount.basementsandandroids3.model.GameState
import com.example.testaccount.basementsandandroids3.network.NetworkHelper
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

import kotlinx.android.synthetic.main.activity_dm.*
import kotlinx.coroutines.experimental.launch
import org.json.JSONObject
import retrofit2.converter.gson.GsonConverterFactory

class DMActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dm)
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
        val networkHelper = NetworkHelper("localhost") //ip address (hardcoded)
        val test = parseJson()
        Log.wtf("DMActivity", test)
        startgame.setOnClickListener {
            launch {     networkHelper.joinAsDM(parseJson()) {
                Log.d("DMActivity", "Joined")
            } }
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

    private fun parseJson(): String {
        val layout = mapLayout
        val gson = Gson()
        val buttons = (0..layout.childCount)
                .map { layout.getChildAt(it) }
                .filterIsInstance<ImageButton>()
        val playerButtons = buttons.filter {
            it.drawable.constantState != ResourcesCompat.getDrawable(resources, R.drawable.enemy, null)?.constantState
                    && it.drawable.constantState != ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher_round, null)?.constantState
        }
        val enemyButtons = buttons.filter {
            it !in playerButtons
        }
        val players = (0 until playerButtons.size)
                .map { GameModel(playerButtons[it].x.toInt(), playerButtons[it].y.toInt(), 10, 10) }
        val enemies = (0 until enemyButtons.size)
                .map { GameModel(enemyButtons[it].x.toInt(), enemyButtons[it].y.toInt(), 10, 10) }
        val playerElement = gson.toJsonTree(players, object : TypeToken<List<GameModel>>() {}.type)
        val enemyElement = gson.toJsonTree(enemies, object : TypeToken<List<GameModel>>() {}.type)
        val finalArray = JsonArray().apply {
            add(playerElement.asJsonArray)
            add(enemyElement.asJsonArray)
        }
        return finalArray.toString()
    }
}
