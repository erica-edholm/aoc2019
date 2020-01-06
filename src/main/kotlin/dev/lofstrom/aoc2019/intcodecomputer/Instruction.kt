package dev.lofstrom.aoc2019.intcodecomputer

import dev.lofstrom.aoc2019.intcodecomputer.ParameterMode.Companion.getParameterModeByValue

class Instruction(instruction: Int) {
  private val type: InstructionType
  private val parameterModes: List<ParameterMode>

  init {
    val instructionValues = instruction
        .toString()
        .padStart(5, '0')
        .map { it.toString().toInt() }
        .reversed()

    type = InstructionType.getInstructionByOperationValue(instructionValues[1].toString() + instructionValues[0])
    val modes = mutableListOf<ParameterMode>()
    var parameterIndex = 2
    for (x in 1 until type.numberOfParameters) {
      modes.add(getParameterModeByValue(instructionValues[parameterIndex]))
      parameterIndex++
    }
    parameterModes = modes
  }

  fun getParameterModes(): List<ParameterMode> {
    return parameterModes.toMutableList()
  }

  fun getNumberOfParameters(): Int {
    return this.type.numberOfParameters
  }

  fun getType(): InstructionType {
    return this.type
  }

}