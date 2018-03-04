package utilidades;

public class Dados {
	public static void main(String[] args) {

	}
	
	int contadorAs = 0;
		int contadorK = 0;
		int contadorQ = 0;
		int contadorJ = 0;
		int contador9 = 0;
		int contador8 = 0;
		
	public void tirarDado() {
	

		final int numTiradas = 5;
		System.out.print("Tirada: ");
		for (int i = 0; i < numTiradas; i++) {
			int dado = (int) (Math.random() * 6) + 1;
			switch (dado) {
			case 1:
				System.out.print("As");
				contadorAs++;
				break;
			case 2:
				System.out.print("K");
				contadorK++;
				break;
			case 3:
				System.out.print("Q");
				contadorQ++;
				break;
			case 4:
				System.out.print("J");
				contadorJ++;
				break;
			case 5:
				System.out.print("9");
				contador9++;
				break;
			default:
				System.out.print("8");
				contador8++;
			}
			System.out.print(" ");
		}
	}
}