package dev.lofstrom.aoc2019.intcodecomputer

import java.lang.IllegalArgumentException

enum class InstructionType(val operationValue: String, val numberOfInstructions: Int, val function: (Int, Int) -> Int) {

  ADDITION("01", 4, {a,b -> a.plus(b)}),
  MULTIPLICATION("02", 4, {a,b -> a.times(b)}),
  EXIT("99", 2, {a,_ -> a});

  companion object {
    fun getInstructionByOperationValue(findValue: String): InstructionType =
        values().firstOrNull {
      it.operationValue == findValue
    }?: throw IllegalArgumentException("Could not find any instructions with the value: $findValue")
  }

}

