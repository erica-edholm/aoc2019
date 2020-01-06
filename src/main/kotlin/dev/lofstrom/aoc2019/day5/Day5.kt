package dev.lofstrom.aoc2019.day5

import dev.lofstrom.aoc2019.Solver
import dev.lofstrom.aoc2019.intcodecomputer.IntCodeComputer

class Day5 : Solver() {

  override fun solvePart1(input: String): Any {
    val intCodeComputer = IntCodeComputer(input)
    return intCodeComputer.executeIntCodeWithInput(1)
  }

  override fun solvePart2(input: String): Any {
    val intCodeComputer = IntCodeComputer(input)
    return intCodeComputer.executeIntCodeWithInput(5)
  }

}