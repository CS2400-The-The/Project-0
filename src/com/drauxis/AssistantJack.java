package com.drauxis;

/**
 * Miracosta College CS 112 Project 3
 *
 * AssistantJack.java : Clue-like game in which a virtual
 * assistant is used to determine the correct murder theory
 * (weapon, location, perpetrator) within 20 attempts
 *
 * @author James Hansen
 * 
 */

import java.util.ArrayList;
import java.util.Random;

public class AssistantJack {

	private int timesAsked;
	private Theory correctTheory;

	/**
	 * private default constructor
	 */
	private AssistantJack() {
		this.timesAsked = 0;
		this.correctTheory = null;
	}

	/**
	 * @param answerSet
	 *            1 = (1,1,1)
	 *            2 = (6,10,6)
	 *            all other integers randomly assigned
	 */
	public AssistantJack(int answerSet) {
		this();

		if (answerSet == 1) {
			this.correctTheory = new Theory(1, 1, 1);
		} else if (answerSet == 2) {
			this.correctTheory = new Theory(6, 10, 6);
		} else {
			Random random = new Random();
			int weapon = random.nextInt(6) + 1;
			int location = random.nextInt(10) + 1;
			int person = random.nextInt(6) + 1;
			this.correctTheory = new Theory(weapon, location, person);
		}
	}

	/**
	 * constructor
	 *
	 */
	public AssistantJack(Theory theory) {
		this();
		this.correctTheory = new Theory(theory);
	}

	/**
	 * Will report to the user whether their theory is correct.
	 * 
	 * @param weapon
	 *            the weapon used 1 - 6
	 * @param location
	 *            the location where it was done 1 - 10
	 * @param person
	 *            the person who did it 1 - 6
	 * @return 0 if all three are correct, 1 if the weapon is incorrect, 2 if
	 *         the location is incorrect and 3 if the person is incorrect.
	 */
	public int checkAnswer(int weapon, int location, int person) {
		ArrayList<Integer> wrongItems = new ArrayList<Integer>(); 

		this.timesAsked++;

		if (this.correctTheory.getWeapon() != weapon) {
			wrongItems.add(1);
		}

		if (this.correctTheory.getLocation() != location) {
			wrongItems.add(2);
		}

		if (this.correctTheory.getPerson() != person) {
			wrongItems.add(3);
		}

		if (wrongItems.size() == 0) {
			return 0;
		} else if (wrongItems.size() == 1) {
			return wrongItems.get(0);
		} else {
			Random random = new Random();
			int randomSelected = random.nextInt(wrongItems.size());
			return wrongItems.get(randomSelected);
		}
	}

	/**
	 * @param theory
	 *            a theory of the murder, weapon and location
	 */
	public int checkAnswer(Theory theory) {
		return this.checkAnswer(theory.getWeapon(), theory.getLocation(), theory.getPerson());
	}

	/**
	 * @return number of times AssistantJack has checkAnswer() been called
	 */
	public int getTimesAsked() {
		return this.timesAsked;
	}
}