package cap02.Repasopdf;

public class HeredaHilo extends Thread {

	String imprimir = "Bitelch�s";

	public HeredaHilo(String impr) {
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
