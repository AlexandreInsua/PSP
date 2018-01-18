package escritoresLectores;

public class Escritor extends Thread {
	private int id;
	private int tempo;
	private Monitor monitor;

	public Escritor(int id, int tempo, Monitor monitor) {
		super();
		this.id = id;
		this.tempo = tempo;
		this.monitor = monitor;
	}

	private void escribir() throws InterruptedException {
		System.out.println("O escritor " + id + " está escribindo: " + monitor);
		
		sleep(tempo * 1000);
		System.out.println("O escritor " + id + " acabou: " + monitor);
	}

	public void run() {
		boolean escribindo = false;
		try {
			System.out.println("Escritor " + id + " quere escribir");
			monitor.permisoEscribir(); 
			escribindo = true;
			escribir();

		} catch (Exception e) {
			System.out.println("O escritor " + id + " foi interrompido.");
		} finally {
			if (escribindo) {
				monitor.finEscribir();
			}
		}
	}

	public String toString() {
		return "escritor(" + id + ") ";
	}
}
