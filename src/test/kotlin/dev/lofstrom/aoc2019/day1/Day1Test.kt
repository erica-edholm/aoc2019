package dev.lofstrom.aoc2019.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1Test {

  private val exampleInput1 = 12
  private val exampleInput2 = 14
  private val exampleInput3 = 1969
  private val exampleInput4 = 100756

  private val exampleOutput1a = 2
  private val exampleOutput2a = 2
  private val exampleOutput3a = 654
  private val exampleOutput4a = 33583

  private val exampleOutput1b = 2
  private val exampleOutput2b = 2
  private val exampleOutput3b = 966
  private val exampleOutput4b = 50346

  val input = StringBuilder()
      .append(exampleInput1).appendln()
      .append(exampleInput2).appendln()
      .append(exampleInput3).appendln()
      .append(exampleInput4)
      .toString()

  private val fuelCounterUpper = Day1()

  @Test
  fun `should calculate correct fuel amount for given mass`() {
    assertThat(fuelCounterUpper.getFuelByMass(exampleInput1)).isEqualTo(exampleOutput1a);
    assertThat(fuelCounterUpper.getFuelByMass(exampleInput2)).isEqualTo(exampleOutput2a);
    assertThat(fuelCounterUpper.getFuelByMass(exampleInput3)).isEqualTo(exampleOutput3a);
    assertThat(fuelCounterUpper.getFuelByMass(exampleInput4)).isEqualTo(exampleOutput4a);
  }

  @Test
  fun `should calculate correct fuel amount for given mass including the fuels mass`() {
    assertThat(fuelCounterUpper.getFuelByMassWithAddedFuelMass(exampleInput1)).isEqualTo(exampleOutput1b);
    assertThat(fuelCounterUpper.getFuelByMassWithAddedFuelMass(exampleInput2)).isEqualTo(exampleOutput2b);
    assertThat(fuelCounterUpper.getFuelByMassWithAddedFuelMass(exampleInput3)).isEqualTo(exampleOutput3b);
    assertThat(fuelCounterUpper.getFuelByMassWithAddedFuelMass(exampleInput4)).isEqualTo(exampleOutput4b);
  }

  @Test
  fun `should solve total fuel consumption for all masses`() {
    val solution = fuelCounterUpper.solvePart1(input)
    assertThat(solution).isEqualTo(exampleOutput1a + exampleOutput2a + exampleOutput3a + exampleOutput4a)
  }

  @Test
  fun `should solve total fuel consumption for all masses including the fuels mass`() {
    val solution = fuelCounterUpper.solvePart2(input)
    assertThat(solution).isEqualTo(exampleOutput1b + exampleOutput2b + exampleOutput3b + exampleOutput4b)
  }


}