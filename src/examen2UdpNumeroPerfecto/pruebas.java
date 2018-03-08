package examen2UdpNumeroPerfecto;

public class pruebas {

	public static void main(String[] args) {
		System.out.println(esPerfecto(14));

	}

	private static int esPerfecto(int a) {
		int[] divisores = new int[a - 1];
		int j = 0;
		for (int i = 1; i < a; i++) {
			if (a % i == 0) {
				divisores[j] = i;
				j++;
			}
		}
		for (int i = 0; i < divisores.length; i++) {
			System.out.println(divisores[i]);
		}
		int resultado = 0;
		for (int i = 0; i < divisores.length; i++) {
			resultado += divisores[i];
		}
		System.out.println();
		if (resultado == a) {
			return 1;
		} else {
			return 0;
		}
	}
}
