package com.example.testaccount.basementsandandroids3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.chichow25.basementsandandroids.repo.gamedata.Monster
import com.example.testaccount.basementsandandroids3.repo.retrofit.await
import com.example.testaccount.basementsandandroids3.repo.retrofit.getMonsterIndexes
import com.example.testaccount.basementsandandroids3.repo.retrofit.loadMonsterInfosFromAssets
import com.example.testaccount.basementsandandroids3.retrofit.DndApi
import kotlinx.android.synthetic.main.activity_monster.*
import kotlinx.coroutines.experimental.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MonsterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster)

        //retrofit
        val api = Retrofit.Builder()
                .baseUrl(DndApi.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DndApi::class.java)
        launch {
            val infos = this@MonsterActivity.applicationContext.loadMonsterInfosFromAssets()
            val monsters = infos.getMonsterIndexes().map {
                api.getMonsterAt(it).await()
            }
            monsters.forEach {
                monstersTextView.append("ID: ${it._id}\n")
                monstersTextView.append("Speed: ${it.speed}\n\n")
            }
        }
    }
}
