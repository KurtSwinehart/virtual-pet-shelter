package org.wcci.virtualPetTest;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.wcci.virtualPet.VirtualPet;
import org.wcci.virtualPet.VirtualPetShelter;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Chewie", 20, 20, 20);
		pet2 = new VirtualPet("Max", 20, 20, 20);
	}

	@Test
	public void shouldIncreasePetTotalFromZeroToOneWhenAdmittingPet() {
		underTest.add(pet1);
		VirtualPet retrievedPet = underTest.findPet("Chewie");
		String result = retrievedPet.getPetName();
		assertThat(result, is("Chewie"));
	}

	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet1, pet2));
	}

	@Test
	public void shouldBeAbleToAdoptAPet() {
		underTest.add(pet1);
		underTest.remove(pet1);
		VirtualPet adoptedPet = underTest.findPet(pet1.getPetName());
		assertThat(adoptedPet, is(nullValue()));
	}
}
