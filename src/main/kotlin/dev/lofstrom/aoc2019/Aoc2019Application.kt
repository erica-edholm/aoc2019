package dev.lofstrom.aoc2019

class Aoc2019Application

fun main(args: Array<String>) {

	val chosenDays: Array<String> =
			if(args.isNotEmpty()) {
				args
			}
			else {
				generateSequence(1) { it + 1  }.take(25).toList().map { it.toString() }.toTypedArray()
			}

    chosenDays.forEach { invokeSolver(it) }
}

fun invokeSolver(day: String) {
	val foundClass = Class.forName("dev.lofstrom.aoc2019.Day$day")
	val newSolver: Solver = foundClass.getDeclaredConstructor().newInstance() as Solver
	newSolver.printSolution(day.toInt())

}
