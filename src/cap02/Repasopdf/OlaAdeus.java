
package cap02.Repasopdf;

public class OlaAdeus {
	public static void main(String[] args) {
		OlaAdeus oa = new OlaAdeus();
		Ola o = new Ola(oa);
		Adeus a = new Adeus(oa);

		o.start();
		a.start();
	}

	boolean escritoOla = false;

	synchronized public void escribirOla() throws InterruptedException {
		if (escritoOla) {
			wait();
		} else {
			System.out.println("Ola");
			escritoOla = true;
			notify();
		}
	}

	synchronized public void escribirAdeus() throws InterruptedException {
		if (escritoOla) {
			System.out.println("Adeus");
			escritoOla = false;
			notify();
		} else {
		
		}
	}

}

class Ola extends Thread {
	OlaAdeus olaAdeus;

	Ola(OlaAdeus o) {
		olaAdeus = o;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				olaAdeus.escribirOla();
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Adeus extends Thread {
	OlaAdeus olaAdeus;

	Adeus(OlaAdeus o) {
		olaAdeus = o;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				olaAdeus.escribirAdeus();
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Test {

}