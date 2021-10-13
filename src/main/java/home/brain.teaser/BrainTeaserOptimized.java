package home.brain.teaser;

import java.util.Scanner;

public class BrainTeaserOptimized {

	private static int getFinalNumber(int power) {
		if (power == 0) {
			return 0;
		}
		if (power % 2 == 0) {
			return getFinalNumberBasedOnValues(0, 4, power);
		}
		return getFinalNumberBasedOnValues(1, -1, power);
	}

	private static int getFinalNumberBasedOnValues(int numberToMultiply,
			int numberToAdd, int power) {
		int finalNumber = 4 * numberToMultiply + numberToAdd;
		while (finalNumber < Math.pow(2, power)) {
			finalNumber = 4 * (finalNumber) + numberToAdd;
		}
		return finalNumber;
	}

	private static String getWinnerOfRound(int numberForRound) {
		int power = 0;
		while (numberForRound >= Math.pow(2, power)) {
			power = power + 1;
		}
		int finalNumber = getFinalNumber(power - 1);
		System.out.println("Final number : " + finalNumber);
		int result = numberForRound - finalNumber;
		return ((result == 0 || result == -1 || result == 1) && Integer
				.toBinaryString(numberForRound).length() % 2 == 0) ? "Y" : "X";
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rounds : ");
		int numberOfRounds = scanner.nextInt();
		if (numberOfRounds >= 1 && numberOfRounds <= Math.pow(10, 6)) {
			for (int i = 0; i < numberOfRounds; i++) {
				System.out.print("Enter number for round " + (i + 1) + " : ");
				int numberForRound = scanner.nextInt();
				if (numberForRound >= 1 && numberForRound <= Math.pow(10, 6)) {
					System.out.println("Winner : "
							+ getWinnerOfRound(numberForRound));
					System.out
							.println("********************************************");
				} else {
					System.out.println("Invalid number for round!");
				}
			}
		} else {
			System.out.println("Invalid number of rounds!");
		}
	}

}
