package cap02;

/*
 * Exemplo que demostra o uso das prioridade. O de maior prioridade dev�lve un n�mero maior
 */
public class Exemplo09_prioridade {
	public static void main(String[] args) {
		ExemploPrioridade fio1 = new ExemploPrioridade();
		ExemploPrioridade fio2 = new ExemploPrioridade();
		ExemploPrioridade fio3 = new ExemploPrioridade();

		fio1.setPriority(Thread.NORM_PRIORITY);
		fio2.setPriority(Thread.MAX_PRIORITY);
		fio3.setPriority(Thread.MIN_PRIORITY);

		fio1.start();
		fio2.start();
		fio3.start();

		try {
			Thread.sleep(100);
		} catch (Exception e) {

		}

		fio1.pararFio();
		fio2.pararFio();
		fio3.pararFio();

		System.out.println("Fio 2 (Prioridade m�xima): " + fio2.getContador());
		System.out.println("Fio 1 (Prioridade normal): " + fio1.getContador());
		System.out.println("Fio 3 (Prioridade minima): " + fio3.getContador());
	}
}

class ExemploPrioridade extends Thread {
	// contador
	private int c = 0;
	// variable para deter o f�o de maneira seugra
	private boolean stopFio = false;

	public int getContador() {
		return c;
	}

	public void pararFio() {
		stopFio = true;
	}

	public void run(){
		while(!stopFio) {
			c++;
		}
	}
}