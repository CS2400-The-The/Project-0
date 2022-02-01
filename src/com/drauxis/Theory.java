package com.drauxis;

/**
@author James Hansen
 */

public class Theory {
	private int weapon;
	private int location;
	private int person;

	/**
	 * theory constructor
	 * 
	 * @param weapon
	 *            integer representing weapon
	 * @param location
	 *            integer representing location
	 * @param person
	 *            integer representing person
	 * 
	 * @see TheoryItem for values
	 */
	public Theory(int weapon, int location, int person) {
		this.weapon = weapon;
		this.location = location;
		this.person = person;
	}

	/**
	 * copy constructor
	 * @param other
	 *            used to get all theory parts and deep copy
	 */
	public Theory(Theory other) {
		this.weapon = other.weapon;
		this.location = other.location;
		this.person = other.person;
	}

	/**
	 * Accessors/Mutators
	 */

	public int getWeapon() {
		return weapon;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	/**
	 * Equals method checks if all params are equal
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Theory other = (Theory) obj;

		return (this.weapon != other.weapon || this.person != other.person || this.location != other.location);

	}

	/**
	 * prints theory object
	 * 
	 * @return formatted string of weapon, person, and location
	 */
	@Override
	public String toString() {
		return String.format("Weapon: %s (%d), Person: %s (%d), Location: %s (%d)",
				TheoryItem.getWeaponName(this.weapon), this.weapon, TheoryItem.getPersonName(this.person), this.person,
				TheoryItem.getLocationName(this.location), this.location);
	}

}