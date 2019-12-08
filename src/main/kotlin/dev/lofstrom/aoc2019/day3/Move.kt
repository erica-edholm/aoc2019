package dev.lofstrom.aoc2019.day3

data class Move(val direction: Direction, val steps: Int)

fun List<Move>.toPositions(startPosition: Position): List<Position> {
  val positions: MutableList<Position> = mutableListOf()
  positions.add(startPosition)

  for(move in this) {
    positions.addAll(positions.last().applyMove(move))
  }
  return positions
}