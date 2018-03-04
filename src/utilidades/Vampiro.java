package utilidades;

import java.util.Scanner;

public class Vampiro {

	public static boolean verificaNum(int numero, int[] digitos) {
		// verifica si esta en las posibles combinaciones
		String numS = numero + "";
		int ok = 0, numAc, len = numS.length();

		for (int i = 0; i < len; i++) {
			numAc = Integer.parseInt(numS.substring(i, i + 1));
			for (int j = 0; j < digitos.length; j++) {
				if (numAc == (digitos[j])) {
					ok++;
					break;
				}
			}
		}
		if (ok == len) {
			return true;
		}
		return false;
	}

	public static boolean esVampiro(int n) {
		String num = n + "";
		int lon = num.length(), ini = 1;
		int[] a = new int[lon]; // Array para los digitos

		if (lon % 2 != 0) { // Si los digitos del numeros es impar no es vampiro
			return false;
		}

		for (int i = 0; i < lon; i++) {
			a[i] = Integer.parseInt(num.substring(i, i + 1));
		}

		for (int i = 1; i < lon / 2; i++) {
			ini *= 10;
		}

		for (int i = ini; i < ini * 10; i++) {
			for (int j = ini; j < ini * 10; j++) {
				if (i * j == n && verificaNum(i, a) && verificaNum(j, a)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número de cuatro cifras: ");
		int nu = sc.nextInt();
		System.out.print("El número " + nu);
		if (esVampiro(nu)) {
			System.out.println(" es vampiro.");
			return;
		}
		System.out.println(" no es vampiro.");

	}
}
