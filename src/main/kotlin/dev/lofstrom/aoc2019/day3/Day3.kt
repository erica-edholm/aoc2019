package dev.lofstrom.aoc2019.day3

import dev.lofstrom.aoc2019.Solver
import dev.lofstrom.aoc2019.utils.toStrings

class Day3 : Solver() {

  private val startPosition = Position(0,0)

  override fun solvePart1(input: String): Any {
    val wires: MutableList<List<Position>> = mutableListOf()
    for (wire in input.toStrings("\n")) {
      wires.add(wire
          .toStrings(",")
          .toMoves()
          .toPositions(startPosition))
    }
    val crossingPoints = wires[0].intersect(wires[1].minus(listOf(startPosition)))
    return crossingPoints.map { it.distanceTo(startPosition) }.min()!!
  }

  override fun solvePart2(input: String): Any {
    val wires: MutableList<List<Position>> = mutableListOf()
    for (wire in input.toStrings("\n")) {
      wires.add(wire
          .toStrings(",")
          .toMoves()
          .toPositions(startPosition))
    }
    val crossingPoints = wires[0].intersect(wires[1].minus(listOf(startPosition)))
    var shortestPath = Integer.MAX_VALUE
    for(position in crossingPoints) {
      val possibleShortestPath = wires[0].indexOf(position) + wires[1].indexOf(position)
      if(possibleShortestPath < shortestPath) {
        shortestPath = possibleShortestPath
      }
    }
    return shortestPath
  }

}

fun List<String>.toMoves(): List<Move> = this.map {
  val direction = Direction.fromChar(it[0].toString())
  val nbrOfSteps = Integer.valueOf(it.substring(1))
  Move(direction, nbrOfSteps)
}

