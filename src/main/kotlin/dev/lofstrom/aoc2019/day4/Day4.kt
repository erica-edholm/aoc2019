package dev.lofstrom.aoc2019.day4

import dev.lofstrom.aoc2019.Solver
import org.apache.commons.lang3.StringUtils

class Day4 : Solver() {
  override fun solvePart1(input: String): Any {
    val range = input.split("-")
        .map { it.toInt() }

    var nbrOfValidPassword = 0
    for (i in range[0]..range[1]) {
      if (isValidPasswordSimpleRules(i.toString())) {
        nbrOfValidPassword++
      }
    }
    return nbrOfValidPassword
  }

  override fun solvePart2(input: String): Any {
    val range = input.split("-")
        .map { it.toInt() }

    var nbrOfValidPassword = 0
    for (i in range[0]..range[1]) {
      if (isValidPasswordComplexRules(i.toString())) {
        nbrOfValidPassword++
      }
    }
    return nbrOfValidPassword
  }

  fun isValidPasswordSimpleRules(password: String): Boolean = password.length == 6 && containsOnlyIncreasingDigits(password) && containsAdjacentDigits(password)
  fun isValidPasswordComplexRules(password: String): Boolean = password.length == 6 && containsOnlyIncreasingDigits(password) && containsAdjacentDigitsButNotPartOfLargerGroup(password)

  fun containsOnlyIncreasingDigits(password: String): Boolean {
    val list = password.toList()
    return list.sorted() == list
  }

  fun containsAdjacentDigits(password: String): Boolean {
    return (0..password.length-2)
        .asSequence()
        .filter { password[it] == password[it+1] }
        .count() > 0
  }

  fun containsAdjacentDigitsButNotPartOfLargerGroup(password: String): Boolean {
    return (0..password.length-2)
        .asSequence()
        .filter { password[it] == password[it+1] && StringUtils.countMatches(password, password[it]) == 2 }
        .count() > 0
  }

}

