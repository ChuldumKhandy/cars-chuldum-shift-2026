package com.example.cars.rent.ui

private val ENGINE_VOLUME_REGEX = Regex("""\d+\.\d+""")

fun extractEngineVolume(name: String): String? =
    ENGINE_VOLUME_REGEX.find(name)?.value