package cap02;

/*
 * Crea 10 fios asignándolles unha prioridade determinada. 
 * Parece que o planificador aplica o time-slicing para que todos of fios
 * se executen.
 */
public class Actividade02_4_prioridades extends Thread {

	boolean pararFio = false;

	Actividade02_4_prioridades(String name) {
		this.setName(name);
	}

	public void run() {
		int aux = 0;
		while (!pararFio) {

			System.out.println("Executando " + getName());
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + ": " + i + ": " + getPriority());
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			aux++;
			if (aux == 1) {
				pararFio();
			}
		}

	}

	public void pararFio() {
		pararFio = true;
	}

	public static void main(String[] args) {
		Actividade02_4_prioridades f1 = new Actividade02_4_prioridades("Fío un");
		Actividade02_4_prioridades f2 = new Actividade02_4_prioridades("Fío dous");
		Actividade02_4_prioridades f3 = new Actividade02_4_prioridades("Fío tres");
		Actividade02_4_prioridades f4 = new Actividade02_4_prioridades("Fío catro");
		Actividade02_4_prioridades f5 = new Actividade02_4_prioridades("Fío cinco");
		Actividade02_4_prioridades f6 = new Actividade02_4_prioridades("Fío seis");
		Actividade02_4_prioridades f7 = new Actividade02_4_prioridades("Fío sete");
		Actividade02_4_prioridades f8 = new Actividade02_4_prioridades("Fío oito");
		Actividade02_4_prioridades f9 = new Actividade02_4_prioridades("Fío nove");
		Actividade02_4_prioridades f10 = new Actividade02_4_prioridades("Fío dez");

		f1.setPriority(10);
		f2.setPriority(9);
		f3.setPriority(8);
		f4.setPriority(7);
		f5.setPriority(6);
		f6.setPriority(5);
		f7.setPriority(4);
		f8.setPriority(3);
		f9.setPriority(2);
		f10.setPriority(1);

		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
		f6.start();
		f7.start();
		f8.start();
		f9.start();
		f10.start();
	}
}
