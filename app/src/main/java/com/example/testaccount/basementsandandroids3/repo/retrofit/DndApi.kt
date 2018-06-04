package com.example.testaccount.basementsandandroids3.retrofit

import retrofit2.Call
import com.example.chichow25.basementsandandroids.repo.gamedata.Monster
import com.example.testaccount.basementsandandroids3.retrofit.models.Armor
import com.example.testaccount.basementsandandroids3.retrofit.models.Weapon
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
/*
import android.content.Context
import android.databinding.BindingAdapter
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pManager
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.AppCompatImageView
import android.util.Log
import com.bumptech.glide.Glide
import com.example.chichow25.basementsandandroids.repo.gamedata.EquipmentCategory
import com.example.chichow25.basementsandandroids.repo.gamedata.MonsterInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.suspendCoroutine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers


/**
 * Created by chichow25 on 3/19/18.
 */
suspend fun <T> Call<T>.await() = suspendCoroutine<T> { continuation ->

    enqueue(object : Callback<T> {

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            continuation.resumeWithException(Throwable("Retrofit Callback Failed: ${t?.message}", t))
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.body()?.also {
                continuation.resume(it)
            } ?: continuation.resumeWithException(IllegalStateException("Response body is null"))
        }
    })
}

suspend fun <T> Observable<T>.await() = suspendCoroutine<T> { continuation ->
    observeOn(AndroidSchedulers.mainThread())
    subscribe {
        continuation.resume(it)
    }
}

fun Context.loadEquipmentCategoriesFromAssets(): List<EquipmentCategory> {
    val string = assets.open("equipment_list.json").bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<EquipmentCategory>>() {}.type
    return Gson().fromJson(string, type)
}

fun Context.loadMonsterInfosFromAssets() : List<MonsterInfo> {
    val string = assets.open("monsters_list.json").bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<MonsterInfo>>() {}.type
    return Gson().fromJson(string, type)
}

fun EquipmentCategory.getEquipmentIndexes() = equipment.map { it.url.substringAfterLast('/').toInt() }

fun List<MonsterInfo>.getMonsterIndexes() = map { it.url.substringAfterLast('/').toInt() }

suspend fun WifiP2pManager.isDiscoverPeersSuccessful(channel: WifiP2pManager.Channel): Boolean = suspendCoroutine {
    discoverPeers(channel, object : WifiP2pManager.ActionListener {

        override fun onSuccess() {
            it.resume(true)
        }

        override fun onFailure(reason: Int) {
            Log.e("WifiP2pManager", "discover peers failed with reason code: $reason")
            it.resume(false)
        }

    })
}

suspend fun WifiP2pManager.isConnectSuccessful(channel: WifiP2pManager.Channel, config: WifiP2pConfig): Boolean = suspendCoroutine {
    connect(channel, config, object : WifiP2pManager.ActionListener {

        override fun onSuccess() {
            it.resume(true)
        }

        override fun onFailure(reason: Int) {
            Log.e("WifiP2pManager", "connect failed with reason code: $reason")
            it.resume(false)
        }
    })
}
*/
