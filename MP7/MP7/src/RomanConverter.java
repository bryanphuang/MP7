import java.util.Scanner;

public class RomanConverter {

	/**
	 * @param romanNumerals
	 *            - String of Roman numerals. Assume all inputs are valid.
	 * @return - value of Roman numerals.
	 */

	public static void main(String[] args) {
		String romanNumerals;
		int inputNum;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number!");
		inputNum = input.nextInt();
		System.out.println("Output:" + "\n" + toRoman(inputNum));
		romanNumerals  = toRoman(inputNum);
		System.out.println("Input:"+ "\n" +convertNumber(romanNumerals));
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