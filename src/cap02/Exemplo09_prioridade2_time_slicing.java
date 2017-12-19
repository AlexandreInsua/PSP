package cap02;

/*
 * Exemplo que demostra a técnica do time-slicing ou tempo compartido 
 * que utiliza o planificador para evitar que un "fío egoísta" en execución 
 * non cede o control a outros procesos o que impida que se executen.
 */
public class Exemplo09_prioridade2_time_slicing extends Thread {

	Exemplo09_prioridade2_time_slicing(String nome) {
		// repara na maneira de establecer o nome
		this.setName(nome);
	}

	public void run() {
		System.out.println("Executando [" + getName() + "]");
		for (int i = 1; i <= 5; i++) {
			System.out.println("\t(" + getName() + ": " + i + ")");
		}
	}

	public static void main(String[] args) {
		Exemplo09_prioridade2_time_slicing fio1 = new Exemplo09_prioridade2_time_slicing("Un");
		Exemplo09_prioridade2_time_slicing fio2 = new Exemplo09_prioridade2_time_slicing("Dous");
		Exemplo09_prioridade2_time_slicing fio3 = new Exemplo09_prioridade2_time_slicing("Tres");
		Exemplo09_prioridade2_time_slicing fio4 = new Exemplo09_prioridade2_time_slicing("Catro");
		Exemplo09_prioridade2_time_slicing fio5 = new Exemplo09_prioridade2_time_slicing("Cinco");

		// Asignamos a prioridade
		fio1.setPriority(MIN_PRIORITY);
		fio2.setPriority(3);
		fio3.setPriority(NORM_PRIORITY);
		fio4.setPriority(7);
		fio5.setPriority(MAX_PRIORITY);

		// Executamos
		fio1.start();
		fio2.start();
		fio3.start();
		fio4.start();
		fio5.start();

	}
}
