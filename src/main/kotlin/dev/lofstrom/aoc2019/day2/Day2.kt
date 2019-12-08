package dev.lofstrom.aoc2019.day2

import dev.lofstrom.aoc2019.Solver
import dev.lofstrom.aoc2019.utils.formatStringToInts
import org.apache.commons.lang3.Validate.isTrue
import java.util.*

private const val WANTED_VALUE = 19690720

private const val ADDITION_OPERATION = 1
private const val MULTIPLICATION_OPERATION = 2
private const val EXIT_OPERATION = 99

class Day2 : Solver() {

  override fun solvePart1(input: String): Any {
    val program = input
        .formatStringToInts()
        .toMutableList()
    executeIntCode(program)
    return program.getProgramOutput()
  }


  override fun solvePart2(input: String): Any {
    val program = input
        .formatStringToInts()
    for (noun in 0..100) {
      for (verb in 0..100) {
        val initializedProgram = program.toMutableList()
        isTrue(Objects.equals(program, initializedProgram), "The memory is not reset")
        val output = executeIntCode(initializedProgram, noun, verb)
        if (output.getProgramOutput() == WANTED_VALUE) {
          return noun * 100 + verb
        }
      }
    }
    throw IllegalArgumentException("Could not find the solution to the problem")
  }

  fun executeIntCode(program: MutableList<Int>, noun: Int = 12, verb: Int = 2): MutableList<Int> {
    program[1] = noun
    program[2] = verb
    for (i in program.indices step 4) {
      when (program[i]) {
        ADDITION_OPERATION -> program[program[i + 3]] = program[program[i+1]].plus(program[program[i+2]])
        MULTIPLICATION_OPERATION -> program[program[i + 3]] = program[program[i+1]].times(program[program[i+2]])
        EXIT_OPERATION -> return program
        else -> throw IllegalArgumentException("Unexpected operation: " + program[i] + " received" )
      }
    }
    throw IllegalArgumentException("Program did not exist as expected")
  }

  private fun List<Int>.getProgramOutput(): Int = this[0]

}