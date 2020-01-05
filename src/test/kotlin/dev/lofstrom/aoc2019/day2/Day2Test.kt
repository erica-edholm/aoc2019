package dev.lofstrom.aoc2019.day2

import dev.lofstrom.aoc2019.intcodecomputer.IntCodeComputer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

  private val exampleInput1 = mutableListOf(1,0,0,0,99)
  private val exampleInput2 = mutableListOf(2,3,0,3,99)
  private val exampleInput3 = mutableListOf(2,4,4,5,99,0)
  private val exampleInput4 = mutableListOf(1,1,1,4,99,5,6,0,99)

  private val exampleInput1AsString = "1,0,0,0,99"
  private val exampleInput2AsString = "2,3,0,3,99"
  private val exampleInput3AsString = "2,4,4,5,99,0"
  private val exampleInput4AsString = "1,1,1,4,99,5,6,0,99"


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

  @Test
  fun `should execute intcode program on new intcode computer`() {
    val intCodeComputer1 = IntCodeComputer(exampleInput1AsString)
    val intCodeComputer2 = IntCodeComputer(exampleInput2AsString)
    val intCodeComputer3 = IntCodeComputer(exampleInput3AsString)
    val intCodeComputer4 = IntCodeComputer(exampleInput4AsString)

    assertThat(intCodeComputer1.executeIntCodeWithNounAndVerb(0, 0)).isEqualTo(exampleOutput1a);
    assertThat(intCodeComputer2.executeIntCodeWithNounAndVerb(3, 0)).isEqualTo(exampleOutput2a);
    assertThat(intCodeComputer3.executeIntCodeWithNounAndVerb(4, 4)).isEqualTo(exampleOutput3a);
    assertThat(intCodeComputer4.executeIntCodeWithNounAndVerb(1, 1)).isEqualTo(exampleOutput4a);
  }
}