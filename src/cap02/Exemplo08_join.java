package cap02;

/*
 * Método join() - unirse, que fai que o fio que fai a chama agarde pola finalición dos outros fíos.
 * Neste caso o main agarda pola finalización dos outros
 */
public class Exemplo08_join extends Thread {
	private int n;

	public Exemplo08_join(String nome, int n) {
		super(nome);
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.println(getName() + ": " + i);
			try {
				sleep(500);
			} catch (InterruptedException ie) {
			}

		}
		System.out.println("Fin bucle: " + getName());
	}
	
	public static void main(String[] args) {
		Exemplo08_join f1 = new Exemplo08_join("Fío 1", 2);
		Exemplo08_join f2 = new Exemplo08_join("Fío 2", 5);
		Exemplo08_join f3 = new Exemplo08_join("Fío 3", 7);
		f1.start();
		f2.start();
		f3.start();
		
		try{
			f1.join();
			f2.join();
			f3.join();
		} catch (InterruptedException ie){}
		System.out.println("Final de programa");
	}
}
