import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanConverter {

	/**
	 * @param romanNumerals
	 *            - String of Roman numerals. Assume all inputs are valid.
	 * @return - value of Roman numerals.
	 */

	public static void main(String[] args) {
		String numeral1 = null;
		String numeral2 = null;
		String operation = null;
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		
		while (!validInput) {
			System.out.println("Enter the first numeral.");
			numeral1 = input.nextLine();
			if (validRoman(numeral1)) {
				validInput = true;
				System.out.println("Input 1: " + numeral1);
			} else {
				System.out.println("Invalid input.");
			}
		}
		
		validInput = false;
		
		while (!validInput) {
			System.out.println("Enter the second numeral.");
			numeral2 = input.nextLine();
			if (validRoman(numeral2)) {
				validInput = true;
				System.out.println("Input 2: " + numeral2);
			} else {
				System.out.println("Invalid input.");
			}
			
		}
		
		validInput = false;
		
		while (!validInput) {
			System.out.println("Enter the operation (+, -, *).");
			operation = input.nextLine();
			if (validOperation(operation)) {
				validInput = true;
				System.out.println("Operation: " + operation);
			} else {
				System.out.println("Invalid input.");
			}
			
		}

		System.out.println("Result:");
		System.out.print(numeral1 + " " + operation + " " + numeral2 + " = ");
		
		if (operation.equals("+")) {
			System.out.println(AddRomNums(numeral1, numeral2));
		} else if (operation.equals("-")) {
			System.out.println(SubtractRomNums(numeral1, numeral2));
		} else {
			System.out.println(MultiplyRomNums(numeral1, numeral2));
		}
	}
	
	public static String AddRomNums(String Input_1, String Input_2) {
		int addInputNum_1 = convertNumber(Input_1);
		int addInputNum_2 = convertNumber(Input_2);
		int addOutput = addInputNum_1 + addInputNum_2;
		String romAddOutput = toRoman(addOutput);
		return romAddOutput;
	}
	
	public static String MultiplyRomNums(String Input_1, String Input_2) {
		int multInputNum_1 = convertNumber(Input_1);
		int multInputNum_2 = convertNumber(Input_2);
		int multOutput = multInputNum_1 * multInputNum_2;
		String romMultOutput = toRoman(multOutput);
		return romMultOutput;
	}
	
	public static String SubtractRomNums(String Input_1, String Input_2) {
		int subInputNum_1 = convertNumber(Input_1);
		int subInputNum_2 = convertNumber(Input_2);
		int subOutput = 0;
		if (subInputNum_1 > subInputNum_2) {
			subOutput = subInputNum_1 - subInputNum_2;
			String romSubOutput = toRoman(subOutput);
			return romSubOutput;
		}
		else {
			return "Negative numeral.";
		}
	}
	
	private static boolean validOperation(String operation) {
		return operation.equals("*") || operation.equals("+") || operation.equals("-");
	}

	public static boolean validRoman(String roman) {		
		return roman.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
	}

	public static int convertNumber(String romanNumerals) {
		int total = 0;

		for (int i = 0; i < romanNumerals.length() - 1; i++) {
			int current = romanValue(romanNumerals.charAt(i));

			int next = romanValue(romanNumerals.charAt(i + 1));

			if (current < next) {
				total -= current;
			} else {
				total += current;
			}
		}

		total += romanValue(romanNumerals.charAt(romanNumerals.length() - 1));

		return total;
	}

	public static int romanValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}

	}

	public static String toRoman(int inputNum) {
		StringBuilder stringBuilder = new StringBuilder();
		int instance = 0;
		String[] romNums = new String [] {"I", "IV", "V", "IX", "X", "XL", "L",
	            "XC", "C", "CD", "D", "CM", "M"};
		int[] nums = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
	            900, 1000 };
		for (int i = nums.length - 1; i >= 0; i--) {
			instance = inputNum / nums[i];
			inputNum %= nums[i];
			while (instance > 0) {
				stringBuilder.append(romNums[i]);
				instance--;
			}
		}
		return stringBuilder.toString();
	}
	
}