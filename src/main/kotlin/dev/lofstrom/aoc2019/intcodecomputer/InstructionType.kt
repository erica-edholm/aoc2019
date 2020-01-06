package dev.lofstrom.aoc2019.intcodecomputer

enum class InstructionType(val operationValue: String, val numberOfParameters: Int) {

  ADDITION("01", 4),
  MULTIPLICATION("02", 4),
  INPUT("03", 2),
  OUTPUT("04", 2),
  JUMP_IF_TRUE("05", 3),
  JUMP_IF_FALSE("06", 3),
  LESS_THAN("07", 4),
  EQUALS("08", 4),
  EXIT("99", 1);

  companion object {
    fun getInstructionByOperationValue(findValue: String): InstructionType =
        values().firstOrNull {
      it.operationValue == findValue
    }?: throw IllegalArgumentException("Could not find any instructions with the value: $findValue")
  }

}

