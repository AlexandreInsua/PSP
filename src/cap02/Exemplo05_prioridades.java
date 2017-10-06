package cap02;

public class Exemplo05_prioridades extends Thread {
	private int c = 0;
	private boolean stopfio = false;

	public int getContador() {
		return c;
	}

	public void pararfio() {
		stopfio = true;
	}

	public void run() {
		while (!stopfio) {
			c++;
			System.out.println(getName() + ": " + getContador());
		}
	}

	public static void main(String[] args) {
		Exemplo05_prioridades name = new Exemplo05_prioridades();
		Exemplo05_prioridades name2 = new Exemplo05_prioridades();
		Exemplo05_prioridades name3 = new Exemplo05_prioridades();

		name.setPriority(NORM_PRIORITY);
		name2.setPriority(MAX_PRIORITY);
		name3.setPriority(MIN_PRIORITY);
		name.start();
		name2.start();
		name3.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		name.pararfio();
		name2.pararfio();
		name3.pararfio();
		System.out.println("name 2 (prio máx.)" + name2.getPriority());
		System.out.println("name 1 (prio med.)" + name2.getPriority());
		System.out.println("name 3 (prio min.)" + name2.getPriority());
	}
}
