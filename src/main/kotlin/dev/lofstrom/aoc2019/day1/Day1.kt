package dev.lofstrom.aoc2019.day1

import dev.lofstrom.aoc2019.Solver
import dev.lofstrom.aoc2019.utils.toInts

class Day1 : Solver() {
  override fun solvePart1(input: String): Any {
    return input
        .toInts("\n")
        .map { getFuelByMass(it) }
        .sum()
  }

  override fun solvePart2(input: String): Any {
    return input
        .toInts("\n")
        .map { getFuelByMassWithAddedFuelMass(it) }
        .sum()
  }

  fun getFuelByMassWithAddedFuelMass(mass: Int): Int {
    val fuel = getFuelByMass(mass)
    return if (fuel <= 0) {
      0
    } else {
      fuel + getFuelByMassWithAddedFuelMass(fuel)
    }
  }

  fun getFuelByMass(mass: Int): Int {
    return (mass / 3) - 2
  }
}