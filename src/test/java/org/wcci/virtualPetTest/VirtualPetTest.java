package org.wcci.virtualPetTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.wcci.virtualPet.VirtualPet;

public class VirtualPetTest {

	int hungerLevel = 30;
	int thirstLevel = 20;
	int boredomLevel = 20;

	private VirtualPet underTest = new VirtualPet("petName", hungerLevel, thirstLevel, boredomLevel);

	@Test
	public void shouldDecreaseHungerFrom30To10ByFeedingIt() {
		underTest.giveFood(20);
		int check = underTest.getHungerLevel();
		assertThat(check, is(10));
	}

	@Test
	public void shouldDecreaseThirstFrom20To0ByGivingWater() {
		underTest.giveWater(20);
		int check = underTest.getThirstLevel();
		assertThat(check, is(0));
	}

	@Test
	public void shouldDecreaseBoredomFrom20To10ByPlaying() {
		underTest.playWithPet(10);
		int check = underTest.getBoredomLevel();
		assertThat(check, is(10));
	}
}
