package dev.lofstrom.aoc2019.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {

  private val password = Day4()

  @Test
  fun `should determine if password contains only increasing digits`() {
    assertThat(password.containsOnlyIncreasingDigits("111111")).isEqualTo(true)
    assertThat(password.containsOnlyIncreasingDigits("223450")).isEqualTo(false)
    assertThat(password.containsOnlyIncreasingDigits("123789")).isEqualTo(true)
    assertThat(password.containsOnlyIncreasingDigits("112233")).isEqualTo(true)
    assertThat(password.containsOnlyIncreasingDigits("123444")).isEqualTo(true)
    assertThat(password.containsOnlyIncreasingDigits("111122")).isEqualTo(true)
  }

  @Test
  fun `should determine if password contains adjacent digits`() {
    assertThat(password.containsAdjacentDigits("111111")).isEqualTo(true)
    assertThat(password.containsAdjacentDigits("223450")).isEqualTo(true)
    assertThat(password.containsAdjacentDigits("123789")).isEqualTo(false)
    assertThat(password.containsAdjacentDigits("112233")).isEqualTo(true)
    assertThat(password.containsAdjacentDigits("123444")).isEqualTo(true)
    assertThat(password.containsAdjacentDigits("111122")).isEqualTo(true)
  }

  @Test
  fun `should determine if password contains adjacent digits but not part of a larger group`() {
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("111111")).isEqualTo(false)
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("223450")).isEqualTo(true)
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("123789")).isEqualTo(false)
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("112233")).isEqualTo(true)
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("123444")).isEqualTo(false)
    assertThat(password.containsAdjacentDigitsButNotPartOfLargerGroup("111122")).isEqualTo(true)
  }

  @Test
  fun `should find passwords with simple rules`() {
    assertThat(password.isValidPasswordSimpleRules("111111")).isEqualTo(true)
    assertThat(password.isValidPasswordSimpleRules("223450")).isEqualTo(false)
    assertThat(password.isValidPasswordSimpleRules("123789")).isEqualTo(false)
  }

  @Test
  fun `should find passwords with complex rules`() {
    assertThat(password.isValidPasswordComplexRules("112233")).isEqualTo(true)
    assertThat(password.isValidPasswordComplexRules("123444")).isEqualTo(false)
    assertThat(password.isValidPasswordComplexRules("111122")).isEqualTo(true)
  }

}