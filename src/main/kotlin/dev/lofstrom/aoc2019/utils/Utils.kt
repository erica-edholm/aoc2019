package dev.lofstrom.aoc2019.utils

fun String.toInts(delimiter: String): List<Int> = this.split(delimiter).map { it.trim().toInt() }



