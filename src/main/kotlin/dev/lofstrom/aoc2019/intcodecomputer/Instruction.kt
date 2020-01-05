package dev.lofstrom.aoc2019.intcodecomputer

import dev.lofstrom.aoc2019.intcodecomputer.InstructionType.EXIT
import dev.lofstrom.aoc2019.intcodecomputer.ParameterMode.Companion.getParameterModeByValue
import dev.lofstrom.aoc2019.intcodecomputer.ParameterMode.IMMEDIATE

class Instruction(instruction: Int) {
  val type: InstructionType
  private val parameterModes: List<ParameterMode>

  init {
    val instructionValues = instruction
        .toString()
        .padStart(5, '0')
        .map { it.toString().toInt() }
        .reversed()

    type = InstructionType.getInstructionByOperationValue(instructionValues[1].toString() + instructionValues[0])
    parameterModes = listOf(getParameterModeByValue(instructionValues[2]),
        getParameterModeByValue
        (instructionValues[3]), getParameterModeByValue(instructionValues[4]))

  }

  fun applyInstruction(program: MutableList<Int>, currentPointerPosition: Int) {
    val parameterPosition = currentPointerPosition + 1
    val parameters =
        program
            .subList(parameterPosition, currentPointerPosition + type.numberOfInstructions)
    val parametersAfterAppliedModes: List<Int> =
        parameterModes
            .zip(parameters)
            .map { pair ->
              if (pair.first == IMMEDIATE) {
                pair.second
              } else {
                program[pair.second]
              }
            }
    val result = type.function.invoke(parametersAfterAppliedModes[0], parametersAfterAppliedModes[1])
    if(type == InstructionType.ADDITION || type == InstructionType.MULTIPLICATION) {
      program[parameters[2]] = result
    }
  }


}