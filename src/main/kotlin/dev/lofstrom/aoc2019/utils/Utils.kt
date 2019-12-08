package dev.lofstrom.aoc2019.utils

fun String.formatLinesOfStringsToInts(): List<Int> = this.split("\n").map { it.trim().toInt() }

fun String.formatStringToInts(): List<Int> = this.split(",").map { it.trim().toInt() }


