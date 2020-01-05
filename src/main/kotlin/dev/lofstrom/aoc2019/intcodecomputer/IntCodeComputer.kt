package dev.lofstrom.aoc2019.intcodecomputer

import dev.lofstrom.aoc2019.intcodecomputer.InstructionType.ADDITION
import dev.lofstrom.aoc2019.utils.toInts

class IntCodeComputer(input: String) {

  private val initialProgram = input
      .toInts(",")

  fun executeIntCodeWithNounAndVerb(noun: Int = 12, verb: Int = 2): MutableList<Int> {
    val program = initialProgram.toMutableList()
    if(noun > program.size || verb > program.size) {
      throw IllegalArgumentException("Too large noun or verb")
    }
    program[1] = noun
    program[2] = verb
    for (i in program.indices step 4) {
      val instructionValue = program[i]
      val instruction = Instruction(instructionValue)
      if(instruction.type == InstructionType.EXIT) {
        return program
      }
      instruction.applyInstruction(program, i)
    }
    throw IllegalArgumentException("Program did not exist as expected")
  }

  fun executeIntCodeWithInput(input: Int): MutableList<Int> {
    val program = initialProgram.toMutableList()
    var instructionPointer = 0
    while(instructionPointer < program.size) {
      val instructionValue = program[instructionPointer]
      val instruction = Instruction(instructionValue)
      if(instruction.type == InstructionType.EXIT) {
        return program
      }
      instruction.applyInstruction(program, instructionPointer)
      instructionPointer += instruction.type.numberOfInstructions
    }
    throw IllegalArgumentException("Program did not exist as expected")
  }
}
