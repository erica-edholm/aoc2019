package dev.lofstrom.aoc2019.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

  private val exampleInput1 = mutableListOf(1,0,0,0,99)
  private val exampleInput2 = mutableListOf(2,3,0,3,99)
  private val exampleInput3 = mutableListOf(2,4,4,5,99,0)
  private val exampleInput4 = mutableListOf(1,1,1,4,99,5,6,0,99)


  private val exampleOutput1a = listOf(2,0,0,0,99)
  private val exampleOutput2a = listOf(2,3,0,6,99)
  private val exampleOutput3a = listOf(2,4,4,5,99,9801)
  private val exampleOutput4a = listOf(30,1,1,4,2,5,6,0,99)

  private val computer = Day2()

  @Test
  fun `should execute intcode program`() {
    assertThat(computer.executeIntCode(exampleInput1, 0, 0)).isEqualTo(exampleOutput1a);
    assertThat(computer.executeIntCode(exampleInput2, 3, 0)).isEqualTo(exampleOutput2a);
    assertThat(computer.executeIntCode(exampleInput3, 4, 4)).isEqualTo(exampleOutput3a);
    assertThat(computer.executeIntCode(exampleInput4, 1, 1)).isEqualTo(exampleOutput4a);
  }
  
}