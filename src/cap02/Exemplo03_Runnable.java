package cap02;

/* 
 * Exemplo que implementa a interface Runnable
 */

public class Exemplo03_Runnable {
	public static void main(String[] args) {
		// instancia o fio
		Fio f = new Fio(10);
		// inicia o fio tendo en conta que implementa Runnable
		new Thread(f).start();
	}
}

class Fio implements Runnable {
	private int x;
	
// construtor recibe un contador 
	Fio(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		for (int i = 0; i < x; i++) {
			System.out.println("No fío... " + i);
		}
	}
}