package utilidades;

import java.util.Scanner;

public class Gemelos {

	/**
	 * Dos numeros son gemelos si son primos y existe entre ellos una diferencia de
	 * 2.
	 * 
	 * @param a
	 * @param b
	 * @return true o false
	 */
	public static boolean gemelos(int a, int b) {
		int cont = 0, cont2 = 0;

		if (Math.abs(b - a) == 2) {
			for (int i = 1; i <= a; i++) {
				if (a % i == 0) {
					cont++;
				}
			}
			for (int i = 1; i <= b; i++) {
				if (b % i == 0) {
					cont2++;
				}
			}
			return cont == 2 && cont2 == 2;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true){
					System.out.print("Introduce un número entero y positivo:");
		int num1 = sc.nextInt();
		System.out.print("Introduce otro número entero y positivo:");
		int num2 = sc.nextInt();

		boolean SonGemelos = gemelos(num1, num2);

		if (SonGemelos == true)
			System.out.println("Son gemelos");
		else
			System.out.println("No son gemelos");
		}

	}
}
