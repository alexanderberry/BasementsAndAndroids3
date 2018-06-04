package com.example.testaccount.basementsandandroids3.network

import org.json.JSONObject

fun json(vararg map: Pair<String, Any>) = JSONObject().apply {
    map.forEach { put(it.first, it.second) }
}