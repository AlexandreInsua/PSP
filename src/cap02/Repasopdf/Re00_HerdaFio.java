package cap02.Repasopdf;

public class Re00_HerdaFio extends Thread {

	String imprimir = "Bitelchús";

	public Re00_HerdaFio(String impr) {
		this.imprimir = impr;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(imprimir + " " + i);

		}
	}

	public static void main(String[] args) {

	}

}
