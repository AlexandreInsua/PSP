
package cap02.Repasopdf;

public class OlaAdeus {
	public static void main(String[] args) {
		OlaAdeus oa = new OlaAdeus();
		Hilo h1 = new Hilo(oa);
		Hilo h2 = new Hilo(oa);

		h1.start();
		h2.start();
	}

	boolean escritoOla = false;

	synchronized public void escribir() throws InterruptedException {
		if (!escritoOla) {
			System.out.println("Ola");
			escritoOla = true;
		} else {
			System.out.println("Adeus");
			escritoOla = false;
		}
	}

}

class Hilo extends Thread {
	OlaAdeus olaAdeus;

	Hilo(OlaAdeus o) {
		olaAdeus = o;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				olaAdeus.escribir();
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*class Adeus extends Thread {
	OlaAdeus olaAdeus;

	Adeus(OlaAdeus o) {
		olaAdeus = o;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				olaAdeus.escribir();
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}*/
