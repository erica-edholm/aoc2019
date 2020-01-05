package dev.lofstrom.aoc2019.intcodecomputer

enum class ParameterMode(val parameterModeValue: Int) {
  POSITION(0),
  IMMEDIATE(1);

  companion object {
    fun getParameterModeByValue(findValue: Int): ParameterMode = values().first { it.parameterModeValue == findValue }
  }
}