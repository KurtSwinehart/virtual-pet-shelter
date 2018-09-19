package org.wcci.virtualPet;

public class VirtualPet {

	private String petName;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;

	public VirtualPet(String petName, int hungerLevel, int thirstLevel, int boredomLevel) {
		this.petName = petName;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.boredomLevel = boredomLevel;
	}

	public String getPetName() {
		return petName;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public void giveFood(int foodAmount) {
		hungerLevel -= foodAmount;
	}

	public void giveWater(int waterAmount) {
		thirstLevel -= waterAmount;
	}

	public void playWithPet(int playAmount) {
		boredomLevel -= playAmount;
	}

	public void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		boredomLevel += 5;
	}
}
