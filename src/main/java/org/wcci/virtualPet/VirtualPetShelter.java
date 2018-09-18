package org.wcci.virtualPet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;

	public void add(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}

	public void remove(VirtualPet pet) {
		pets.remove(pet.getPetName(), pet);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void feedAll() {
		for (VirtualPet pets : pets.values()) {
			pets.giveFood(10);
		}
	}

	public void waterAll() {
		for (VirtualPet pets : pets.values()) {
			pets.giveWater(10);
		}
	}

	public void play(String petName, int playAmount) {
		VirtualPet petToPlayWith = findPet(petName);
		petToPlayWith.playWithPet(playAmount);
	}

	public void showAllPets() {
		for (VirtualPet pet : pets.values()) {
			System.out.println("Pet name: " + pet.getPetName() + " " + "Hunger Level: " + pet.getHungerLevel() + " "
					+ "Thirst Level: " + pet.getThirstLevel() + "Boredom Level: " + pet.getBoredomLevel());
		}
	}

	public void tick() {
		for (VirtualPet pet : pets.values()) {
			hungerLevel += 10;
			thirstLevel += 10;
			boredomLevel += 10;
		}
	}
}
