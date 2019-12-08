package dev.lofstrom.aoc2019.day3

import kotlin.math.abs

data class Position(val x: Int, val y: Int) {

  fun applyMove(move: Move): List<Position> {
    val positions: MutableList<Position> = mutableListOf()
    for(x in 1..move.steps) {
      positions.add(this.plus(move.direction.position.multiply(x)))
    }
    return positions
  }

  private fun multiply(step: Int): Position = Position(x * step, y * step)

  operator fun plus(other: Position) = Position(this.x + other.x, this.y + other.y)

  fun distanceTo(other: Position) =
      abs(this.x - other.x) +
          abs(this.y - other.y)


}