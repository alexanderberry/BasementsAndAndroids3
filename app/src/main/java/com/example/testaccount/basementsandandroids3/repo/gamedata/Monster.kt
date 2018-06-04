package com.example.chichow25.basementsandandroids.repo.gamedata

data class Monster(
		val _id: String,
		val index: Double,
		val name: String,
		val size: String,
		val type: String,
		val subtype: String,
		val alignment: String,
		val armor_class: Double,
		val hit_poDoubles: Double,
		val hit_dice: String,
		val speed: String,
		val strength: Double,
		val dexterity: Double,
		val constitution: Double,
		val Doubleelligence: Double,
		val wisdom: Double,
		val constitution_save: Double,
		val Doubleelligence_save: Double,
        val wisdom_save: Double,
        val history: Double,
        val perception: Double,
        val damage_vulnerabilities: String,
        val damage_resistances: String,
        val damage_immunities: String,
        val condition_immunities: String,
        val senses: String,
        val languages: String,
//        val challenge_rating: kotlin.Double,
        val special_abilities: List<SpecialAbility>,
        val actions: List<Action>,
        val legendary_actions: List<LegendaryAction>,
        val url: String
)

data class Action(
		val attack_bonus: Double,
		val desc: String,
		val name: String
)

data class SpecialAbility(
		val attack_bonus: Double,
		val desc: String,
		val name: String
)

data class LegendaryAction(
		val attack_bonus: Double,
		val desc: String,
		val name: String
)