package cap02;

/* 
 * Exemplo que implementa a interface Runnable
 */
public class Exemplo03_Runnable {
	public static void main(String[] args) {
		Fio3 applet = new Fio3(10);
		new Thread(applet).start();
	}
}

class Fio3 implements Runnable {
	private int x;

	Fio3(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		for (int i = 0; i < x; i++) {
			System.out.println("No fío... " + i);
		}
	}
}