package utilidades;

public class Palindoromos {
	
	//Da la vuelta a la palabra/frase

	public static void main(String[] args) {

		String palindrome = "A la Catalana Banal atacala";
		int len = palindrome.length();
		char[] tempCharArray = new char[len];
		char[] charArray = new char[len];

		// put original string in an
		// array of chars
		for (int i = 0; i < len; i++) {
			tempCharArray[i] = palindrome.charAt(i);
		}

		// reverse array of chars
		for (int j = 0; j < len; j++) {
			charArray[j] = tempCharArray[len - 1 - j];
		}

		String reversePalindrome = new String(charArray);
		System.out.println(reversePalindrome);
	}

}
