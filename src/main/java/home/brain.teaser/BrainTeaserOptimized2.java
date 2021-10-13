package home.brain.teaser;

import java.util.Scanner;

public class BrainTeaserOptimized2 {

	private static int getDecimalValue(String binaryValue) {
		Double decimalValue = new Double(0);
		for (int i = 0; i < binaryValue.length(); i++) {
			decimalValue = decimalValue
					+ Integer.parseInt(binaryValue.charAt(i) + "")
					* Math.pow(2, binaryValue.length() - 1 - i);
		}
		return decimalValue.intValue();
	}

	private static String getFinalBinaryValue(int length) {
		String finalBinaryValue = "";
		while (length > 2) {
			finalBinaryValue = finalBinaryValue + "10";
			length = length - 2;
		}
		return finalBinaryValue + "11";
	}

	private static String getWinnerOfRound(int numberForRound) {
		String binaryValue = Integer.toBinaryString(numberForRound);
		if (binaryValue.length() % 2 != 0) {
			return "X";
		}
		int finalNumber = getDecimalValue(getFinalBinaryValue(binaryValue
				.length()));
		System.out.println("Final number : " + finalNumber);
		int result = numberForRound - finalNumber;
		return (result == 0 || result == -1 || result == 1) ? "Y" : "X";
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
