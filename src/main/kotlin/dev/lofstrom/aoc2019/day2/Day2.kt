package dev.lofstrom.aoc2019.day2

import dev.lofstrom.aoc2019.Solver
import dev.lofstrom.aoc2019.utils.formatStringToInts
import org.apache.commons.lang3.Validate.isTrue
import java.lang.IllegalArgumentException
import java.util.*

class Day2: Solver() {

  private val operations: Map<Int, (Int, Int) -> Int> = mapOf(
      1 to {x: Int, y:Int -> x.plus(y)},
      2 to {x: Int, y:Int -> x.times(y)}
  )

  override fun solvePart1(input: String): Any {
    val program = input
        .formatStringToInts().toMutableList()
    executeIntCode(program)
    return program[0]
  }


  override fun solvePart2(input: String): Any {
    val program = input
        .formatStringToInts()
    for (noun in 0..100) {
      for (verb in 0..100) {
        val initializedProgram = program.toMutableList()
        isTrue(Objects.equals(program, initializedProgram), "The memory is not reset")
        val output = executeIntCode(initializedProgram, noun, verb)
        if(output[0] == 19690720) {
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
      val operation = program[i]
      if (operation == 99) {
        return program
      }
      else {
        val function = operations[operation]
        if(function != null) {
          val result = function.invoke(program[program[i+1]], program[program[i+2]])
          program[program[i+3]] = result
        }
      }
    }
    throw IllegalArgumentException("Could not find any 99 operations to exit the program")
  }

}