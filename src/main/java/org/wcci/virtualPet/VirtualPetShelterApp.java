package org.wcci.virtualPet;

import java.util.Scanner;

public class VirtualPetShelterApp {

	private static String userChoice;
	private static String petToPlayWith;
	private static String newPetName;
	private static String petToTakeIn;
	private static Object petToAdopt;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();

		myShelter.add(new VirtualPet("Chewie", 20, 10, 10));
		myShelter.add(new VirtualPet("Max", 10, 20, 10));
		myShelter.add(new VirtualPet("Swarley", 20, 30, 15));
		myShelter.add(new VirtualPet("Ginger", 30, 10, 20));

		System.out.println("Thank you for volunteering at Kurt's Pet Shelter.");
		System.out.println("This is the status of your pets: ");
		myShelter.showAllPets();
		System.out.println("");

		menuOptions(input);

		while (!userChoice.equals("7")) {

			if (userChoice.equals("1")) {
				System.out.println("Thanks for feeding all the pets!");
				myShelter.feedAll();
				System.out.println("What would you like to do next?");
				userChoice = input.nextLine();
			} else if (userChoice.equals("2")) {
				System.out.println("Thanks for giving all of the pets some water. What else would you like to do?");
				myShelter.waterAll();
				userChoice = input.nextLine();
			} else if (userChoice.equals("3")) {
				System.out.println("Which pet would you like to play with?");
				petToPlayWith = input.nextLine();
				System.out.println("How long would you like to play with " + petToPlayWith + "?");
				int playAmount = input.nextInt();
				myShelter.play(petToPlayWith, playAmount);
				System.out.println(petToPlayWith + " is much happier now, thanks!");
				menuOptions(input);
				userChoice = input.nextLine();
			} else if (userChoice.equals("4")) {
				System.out.println("Which pet would you like to adopt?");
				petToAdopt = input.nextLine();
				myShelter.pets.remove(petToAdopt);
				System.out.println("Please take great care of " + petToAdopt + ".");
				menuOptions(input);
//				userChoice = input.nextLine();
			} else if (userChoice.equals("5")) {
				System.out.println("What is the new pet's name?");
				String newPetName = input.nextLine();
				System.out.println("Enter hunger level");
				int hungerLevel = input.nextInt();
				System.out.println("Enter thirst level");
				int thirstLevel = input.nextInt();
				System.out.println("Enter boredom level");
				int boredomLevel = input.nextInt();
				input.nextLine();
				VirtualPet newPet = new VirtualPet(newPetName, hungerLevel, thirstLevel, boredomLevel);
				myShelter.add(newPet);
				System.out.println("What would you like to do next?");
				userChoice = input.nextLine();
			} else if (userChoice.equals("6")) {
				myShelter.showAllPets();
				System.out.println("What would you like to do next?");
				userChoice = input.nextLine();
			}
			myShelter.tick();

		}
		System.out.println("Goodbye. Thanks for visiting my Virtual Pet Shelter!");
		System.exit(0);
	}

	static void menuOptions(Scanner input) {
		System.out.println("What would you like to do next?");
		System.out.println("Press 1 to feed the pets.");
		System.out.println("Press 2 to water the pets.");
		System.out.println("Press 3 to play with a pet.");
		System.out.println("Press 4 to adopt a pet.");
		System.out.println("Press 5 to admit a pet.");
		System.out.println("Press 6 to get updated status for all pets.");
		System.out.println("Press 7 to quit.");
		userChoice = input.nextLine();
	}
}
