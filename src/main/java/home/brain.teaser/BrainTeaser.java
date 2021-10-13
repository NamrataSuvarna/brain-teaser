package home.brain.teaser;

import java.util.Scanner;

public class BrainTeaser {

	private static String evaluateWinner(int numberForRound,
			String finalBinaryValue) {
		System.out.println("Final Binary Value : " + finalBinaryValue);
		int finalNumber = getDecimalValue(finalBinaryValue);
		System.out.println("Final number : " + finalNumber);
		int result = Integer.sum(-numberForRound, finalNumber);
		return ((result == 0 || result == -1 || result == 1) && finalBinaryValue
				.length() % 2 == 0) ? "Y" : "X";
	}

	private static int getDecimalValue(String binaryValue) {
		Double decimalValue = new Double(0);
		for (int i = 0; i < binaryValue.length(); i++) {
			decimalValue = decimalValue
					+ Integer.parseInt(binaryValue.charAt(i) + "")
					* Math.pow(2, binaryValue.length() - 1 - i);
		}
		return decimalValue.intValue();
	}

	private static String getWinnerOfRound(int numberForRound) {
		String binaryValue = Integer.toBinaryString(numberForRound);
		System.out.println("Binary Value : " + binaryValue);
		StringBuilder finalBinaryValue = new StringBuilder(binaryValue);
		for (int i = 0; i < binaryValue.length(); i++) {
			char initialValueAtI = finalBinaryValue.charAt(i);
			finalBinaryValue.setCharAt(i, toggleValue(initialValueAtI));
			if (i != 0) {
				finalBinaryValue.setCharAt(i - 1, toggleValue(initialValueAtI));
			}
			if (i != binaryValue.length() - 1) {
				finalBinaryValue.setCharAt(i + 1, toggleValue(initialValueAtI));
			}
		}
		return evaluateWinner(numberForRound, finalBinaryValue.toString());
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

	private static char toggleValue(char c) {
		if (c == '0') {
			return '1';
		}
		return '0';
	}

}
