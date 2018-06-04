package com.example.testaccount.basementsandandroids3.repo.retrofit

import com.example.chichow25.basementsandandroids.repo.gamedata.Monster
import com.example.testaccount.basementsandandroids3.retrofit.models.Armor
import com.example.testaccount.basementsandandroids3.retrofit.models.Weapon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by chichow25 on 3/27/18.
 */
interface DndApi {

    companion object {
        const val baseURL = "http://dnd5eapi.co/api/"
    }

    @GET("equipment/{index}")
    fun getWeaponAt(@Path("index") index: Int): Call<Weapon>

    @GET("equipment/{index}")
    fun getArmourAt(@Path("index") index: Int): Call<Armor>

    @GET("monsters/{index}")
    fun getMonsterAt(@Path("index") index: Int): Call<Monster>
    //asdf
}