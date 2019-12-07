package dev.lofstrom.aoc2019

import org.apache.commons.lang3.Validate.inclusiveBetween
import java.net.URL


abstract class Solver {

    abstract fun solvePart1(input: String): Any
    abstract fun solvePart2(input: String): Any

    fun printSolution(day: Int) {
        val input: String = getInputForDay(day)
        println("Solution for day $day")
        println("---------------------")

        val sum1 = solvePart1(input)
        println("Part 1: $sum1")

        val sum2 = solvePart2(input)
        println("Part 2: $sum2")
        println("---------------------")
        println()
    }

    private fun getInputForDay(day: Int): String {
        inclusiveBetween(1, 24, day)
        val resource: URL = {}::class.java.getResource("/day${day}_input")
        return resource.readText()
    }

}