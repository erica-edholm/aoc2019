package dev.lofstrom.aoc2019.intcodecomputer

import dev.lofstrom.aoc2019.intcodecomputer.InstructionType.*
import dev.lofstrom.aoc2019.utils.toInts

class IntCodeComputer(input: String) {

  private val initialProgram = input
      .toInts(",")

  private val outputs: MutableList<Int> = mutableListOf()

  fun executeIntCodeWithNounAndVerb(noun: Int = 12, verb: Int = 2): MutableList<Int> {
    val program = initialProgram.toMutableList()
    if (noun > program.size || verb > program.size) {
      throw IllegalArgumentException("Too large noun or verb")
    }
    program[1] = noun
    program[2] = verb
    executeProgram(program)
    return program
  }

  fun executeIntCodeWithInput(input: Int): Int {
    executeProgram(initialProgram.toMutableList(), input)
    return outputs.last()
  }

  private fun executeProgram(program: MutableList<Int>, input: Int = 0) {
    var pointer = 0
    program@ while (pointer < program.size) {
      val instruction = Instruction(program[pointer])
      val parameterStartPosition = pointer + 1 // Plus one to skip the instruction on current position
      val parameterEndPosition = pointer + instruction.getNumberOfParameters()
      val parameters = program.subList(parameterStartPosition, parameterEndPosition)
      val parameterValues =
          instruction
              .getParameterModes()
              .zip(parameters)
              .map { if (it.first == ParameterMode.IMMEDIATE) it.second else program[it.second] }

      when (instruction.getType()) {
        ADDITION -> {
          program[parameters[2]] = parameterValues[0].plus(parameterValues[1])
          pointer = parameterEndPosition
        }
        MULTIPLICATION -> {
          program[parameters[2]] = parameterValues[0].times(parameterValues[1])
          pointer = parameterEndPosition
        }
        INPUT -> {
          program[parameters[0]] = input
          pointer = parameterEndPosition
        }
        OUTPUT -> {
          outputs.add(parameterValues[0])
          pointer = parameterEndPosition
        }
        JUMP_IF_TRUE -> {
          pointer = if (parameterValues[0] != 0) {
            parameterValues[1]
          } else {
            parameterEndPosition
          }
        }
        JUMP_IF_FALSE -> {
          pointer = if (parameterValues[0] == 0) {
            parameterValues[1]
          } else {
            parameterEndPosition
          }
        }
        LESS_THAN -> {
          if(parameterValues[0] < parameterValues[1]) {
            program[parameters[2]] = 1
          } else {
            program[parameters[2]] = 0
          }
          pointer = parameterEndPosition
        }
        EQUALS -> {
          if(parameterValues[0] == parameterValues[1]) {
            program[parameters[2]] = 1
          } else {
            program[parameters[2]] = 0
          }
          pointer = parameterEndPosition
        }
        EXIT -> break@program
      }
    }
  }
}
