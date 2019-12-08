package dev.lofstrom.aoc2019.day3

import dev.lofstrom.aoc2019.day3.Direction.*
import dev.lofstrom.aoc2019.utils.toStrings
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test {

  private val exampleInput1List1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72"
  private val exampleInput1List2 = "U62,R66,U55,R34,D71,R55,D58,R83"
  private val exampleInput1 = exampleInput1List1+"\n"+exampleInput1List2

  private val exampleInput2List1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
  private val exampleInput2List2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
  private val exampleInput2 = exampleInput2List1+"\n"+exampleInput2List2

  private val exampleOutput1 = 159
  private val exampleOutput2 = 135

  private val wires = Day3()

  @Test
  fun `should calculate moves from input`() {
    val expectedOutputList1 = listOf(Move(RIGHT, 75), Move(DOWN, 30), Move(RIGHT, 83), Move(UP, 83), Move(LEFT, 12),
        Move(DOWN, 49), Move(RIGHT, 71), Move(UP, 7), Move(LEFT, 72))
    val expectedOutputList2 = listOf(Move(UP, 62), Move(RIGHT, 66), Move(UP, 55), Move(RIGHT, 34), Move(DOWN, 71),
        Move(RIGHT, 55), Move(DOWN, 58), Move(RIGHT, 83))

    val expectedOutputList3 = listOf(Move(RIGHT, 98), Move(UP, 47), Move(RIGHT, 26), Move(DOWN, 63), Move(RIGHT, 33),
        Move(UP, 87), Move(LEFT, 62), Move(DOWN, 20), Move(RIGHT, 33), Move(UP, 53), Move(RIGHT, 51))
    val expectedOutputList4 = listOf(Move(UP, 98), Move(RIGHT, 91), Move(DOWN, 20), Move(RIGHT, 16), Move(DOWN, 67),
        Move(RIGHT, 40), Move(UP, 7), Move(RIGHT, 15), Move(UP, 6), Move(RIGHT, 7))

    assertThat(exampleInput1List1.toStrings(",").toMoves()).isEqualTo(expectedOutputList1);
    assertThat(exampleInput1List2.toStrings(",").toMoves()).isEqualTo(expectedOutputList2);
    assertThat(exampleInput2List1.toStrings(",").toMoves()).isEqualTo(expectedOutputList3);
    assertThat(exampleInput2List2.toStrings(",").toMoves()).isEqualTo(expectedOutputList4);
  }

  @Test
  fun `should find closes intersection to start position`() {

    assertThat(wires.solvePart1(exampleInput1)).isEqualTo(exampleOutput1)
    assertThat(wires.solvePart1(exampleInput2)).isEqualTo(exampleOutput2)
  }

  @Test
  fun `should find shortest path`() {
    assertThat(wires.solvePart2(exampleInput1)).isEqualTo(610)
    assertThat(wires.solvePart2(exampleInput2)).isEqualTo(410)
  }

}