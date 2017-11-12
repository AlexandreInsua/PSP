package cap02;

// Fai que este fio agarde pola finalización de outros fíos
public class Ex05_join extends Thread {
	private int n;

	public Ex05_join(String nom, int n) {
		super(nom);
		this.n = n;
	}

	@Override
	public void run() {
		for (int i = 0; i <= n; i++) {
			System.out.println(getName() + ": " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			

		}System.out.println("Fin de bucle " + getName());
	}

	public static void main(String[] args) {
		Ex05_join n1 = new Ex05_join("Fio 1", 2);
		Ex05_join n2 = new Ex05_join("Fio 2", 5);
		Ex05_join n3 = new Ex05_join("Fio 3", 7);
		n1.start();
		n2.start();
		n3.start();
		try {
			// Colocado aquí, fai que o main() non finaliza até que o faas os que teñen o join()
			n1.join();
			n2.join();
			n3.join();
		} catch (InterruptedException e) {
		}
		System.out.println("fin do programa");
	}

}
