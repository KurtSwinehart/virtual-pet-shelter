package org.wcci.virtualPet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

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
		for (VirtualPet pet : pets.values()) {
			pet.giveFood(10);
		}
	}

	public void waterAll() {
		for (VirtualPet pet : pets.values()) {
			pet.giveWater(10);
		}
	}

	public void play(String petName, int playAmount) {
		VirtualPet petToPlayWith = findPet(petName);
		petToPlayWith.playWithPet(playAmount);
	}
}