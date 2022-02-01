package com.drauxis;

/**
 * RandomClue.java : Random solver for Clue-like game
 * 
 * @author James Hansen
 *
 */

import java.util.Random;
import java.util.Scanner;

public class RandomClue {

	/**
	 * application driver: tests random game outcomes
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int answerSet, solution, murder, weapon, location;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, or 3 [random]):");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);

		Random random = new Random();

		do {
			murder = random.nextInt(6) + 1;
			location = random.nextInt(10) + 1;
			weapon = random.nextInt(6) + 1;
			solution = jack.checkAnswer(weapon, location, murder);
		} while (solution != 0);
		answer = new Theory(weapon, location, murder);
		System.out.println("Total Checks: " + jack.getTimesAsked() + ", Solution: " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("Incorrect!");
		} else {
			System.out.println("Correct!");
		}

	}

}