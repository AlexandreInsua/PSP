package cap02;

public class Actividade01_tic_tac {

	public static void main(String[] args) {
		Watch tic = new Watch("tic");
		Watch tac = new Watch("\ttac");

		while (true) {
			tic.run();
			tac.run();
		}
	}
}

class Watch extends Thread {
	String name;
	String message;

	Watch(String m) {

		this.name = m;
		this.message = m;
	}

	public void run() {

		try {
			System.out.println(this.message);
			sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println("Excepción capturada: ");
			ie.printStackTrace();
		}
	}
}