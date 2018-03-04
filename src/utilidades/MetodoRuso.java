package utilidades;

public class MetodoRuso {
	public static void main(String[] args) {
		
		multiplicacionRusa(33, 34);
	}

	static int multiplicacionRusa(int a, int b) {
		int c = 0;
		while (a != 0) {
			System.out.println(a + " - " + b);
			if (a % 2 != 0) {
				c = c + b;
			}
			a = a / 2;
			b = b * 2;

		}
		System.out.println("resultado: " + c);
		return c;
	}
}
