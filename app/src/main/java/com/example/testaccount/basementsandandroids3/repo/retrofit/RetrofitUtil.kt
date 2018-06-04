package com.example.testaccount.basementsandandroids3.repo.retrofit

import android.content.Context
import com.example.chichow25.basementsandandroids.repo.gamedata.EquipmentCategory
import com.example.chichow25.basementsandandroids.repo.gamedata.MonsterInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.suspendCoroutine

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

fun Context.loadMonsterInfosFromAssets() : List<MonsterInfo> {
    val string = assets.open("monsters_list.json").bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<MonsterInfo>>() {}.type
    return Gson().fromJson(string, type)
}

fun EquipmentCategory.getEquipmentIndexes() = equipment.map { it.url.substringAfterLast('/').toInt() }

fun List<MonsterInfo>.getMonsterIndexes() = map { it.url.substringAfterLast('/').toInt() }