
public class RomanConverter {

	/**
	 * @param romanNumerals - String of roman numerals. Assume all inputs are valid.
	 * @return - value of roman numerals.
	 */
	
	public static void main(String[] args) {
		System.out.println(convertNumber("MXM"));
		System.out.println(convertNumber("XII"));
		System.out.println(convertNumber("XIX"));
		
	}
	
	public static int convertNumber (String romanNumerals) {
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
		
		total += romanValue(romanNumerals.charAt(romanNumerals.length()-1));
		
		return total;
	}
	
	public static int romanValue(char c) {
		switch(c) {
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

}