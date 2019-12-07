package dev.lofstrom.aoc2019

import dev.lofstrom.aoc2019.utils.formatLinesOfStringsToInts

class Day1 : Solver() {
  override fun solvePart1(input: String): Any {
    return input
        .formatLinesOfStringsToInts()
        .map { getFuelByMass(it) }
        .sum()
  }

  override fun solvePart2(input: String): Any {
    return input
        .formatLinesOfStringsToInts()
        .map { getFuelByMassWithAddedFuelMass(it) }
        .sum()
  }

  fun getFuelByMassWithAddedFuelMass(mass: Int): Int {
    val fuel = getFuelByMass(mass)
    return if(fuel <= 0)  {
      0
    } else {
      fuel + getFuelByMassWithAddedFuelMass(fuel)
    }
  }

  fun getFuelByMass(mass: Int): Int {
    return Integer.valueOf(mass / 3) - 2
  }
}