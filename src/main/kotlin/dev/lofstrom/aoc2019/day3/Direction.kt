package dev.lofstrom.aoc2019.day3

enum class Direction(val directionChar: String, val position: Position) {
  UP("U", Position(0,1)),
  RIGHT("R", Position(1, 0)),
  DOWN("D", Position(0,-1)),
  LEFT("L", Position(-1,0));

  companion object {
    fun fromChar(char: String): Direction = Direction.values().firstOrNull { it.directionChar == char }!!
  }

}