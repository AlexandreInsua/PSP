package utilidades;

import java.util.Scanner;

public class Capicua {
	public static void capi(int n) {
		int r, s = 0, k;
		k = n;
		while (n != 0) {
			r = n % 10;
			s = s * 10 + r;
			n = n / 10;
		}
		System.out.print("\nel numero invertido es :" + s);
		if (s == k)
			System.out.println("\nEs capicua ");
		else
			System.out.println("\nNo es capicua ");
	}

	public static void main(String orgs[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introducir numero decimal entero:");
		int n = sc.nextInt();
		capi(n);
	}
}
