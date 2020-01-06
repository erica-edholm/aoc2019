package dev.lofstrom.aoc2019.day5

import dev.lofstrom.aoc2019.intcodecomputer.IntCodeComputer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {

  private val input1 = "3,9,8,9,10,9,4,9,99,-1,8"
  private val input2 = "3,9,7,9,10,9,4,9,99,-1,8"
  private val input3 = "3,3,1108,-1,8,3,4,3,99"
  private val input4 = "3,3,1107,-1,8,3,4,3,99"
  private val input5 = "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9"
  private val input6 = "3,3,1105,-1,9,1101,0,0,12,4,12,99,1"
  private val input7 = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"

  @Test
  fun `should check input equals to 8 in position mode`() {
    val intCodeComputer = IntCodeComputer(input1)
    val result1 = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result1).isEqualTo(1)
    val result2 = intCodeComputer.executeIntCodeWithInput(7)
    assertThat(result2).isEqualTo(0)
  }

  @Test
  fun `should check input less than 8 in position mode`() {
    val intCodeComputer = IntCodeComputer(input2)
    val result1 = intCodeComputer.executeIntCodeWithInput(6)
    assertThat(result1).isEqualTo(1)
    val result2 = intCodeComputer.executeIntCodeWithInput(9)
    assertThat(result2).isEqualTo(0)
  }

  @Test
  fun `should check input equals to 8 in immediate mode`() {
    val intCodeComputer = IntCodeComputer(input3)
    val result1 = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result1).isEqualTo(1)
    val result2 = intCodeComputer.executeIntCodeWithInput(7)
    assertThat(result2).isEqualTo(0)
  }

  @Test
  fun `should check input less than 8 in immediate mode`() {
    val intCodeComputer = IntCodeComputer(input4)
    val result1 = intCodeComputer.executeIntCodeWithInput(6)
    assertThat(result1).isEqualTo(1)
    val result2 = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result2).isEqualTo(0)
  }

  @Test
  fun `should jump correctly depending on input in position mode`() {
    val intCodeComputer = IntCodeComputer(input5)
    val result1 = intCodeComputer.executeIntCodeWithInput(0)
    assertThat(result1).isEqualTo(0)
    val result2 = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result2).isEqualTo(1)
  }

  @Test
  fun `should jump correctly depending on input in immediate mode`() {
    val intCodeComputer = IntCodeComputer(input6)
    val result1 = intCodeComputer.executeIntCodeWithInput(0)
    assertThat(result1).isEqualTo(0)
    val result2 = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result2).isEqualTo(1)
  }

  @Test
  fun `should output 1000 if input equal to 8`() {
    val intCodeComputer = IntCodeComputer(input7)
    val result = intCodeComputer.executeIntCodeWithInput(8)
    assertThat(result).isEqualTo(1000)
  }

  @Test
  fun `should output 999 if input less than 8`() {
    val intCodeComputer = IntCodeComputer(input7)
    val result = intCodeComputer.executeIntCodeWithInput(7)
    assertThat(result).isEqualTo(999)
  }

  @Test
  fun `should output 1001 if input greater than 8`() {
    val intCodeComputer = IntCodeComputer(input7)
    val result = intCodeComputer.executeIntCodeWithInput(9)
    assertThat(result).isEqualTo(1001)
  }
}