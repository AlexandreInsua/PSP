package escritoresLectores;

public class Lector extends Thread {
		private int id;
		private int tempo;
		private Monitor monitor;

		public Lector(int id, int tempo, Monitor monitor) {
			super();
			this.id = id;
			this.tempo = tempo;
			this.monitor = monitor;
		}

		private void ler() throws InterruptedException {
			System.out.println("O lector " + id + " está lendo: " + monitor);
			
			sleep(tempo * 1000);
			System.out.println("O lector " + id + " acabou: " + monitor);
		}

		public void run() {
			boolean lendo = false;
			try {
				System.out.println("Lector " + id + " quere ler");
				monitor.permisoLer();
				lendo = true;
				ler();

			} catch (Exception e) {
				System.out.println("O lector " + id + " foi interrompido.");
			} finally {
				if (lendo) {
					monitor.finLer();
				}
			}
		}

		public String toString() {
			return "lector(" + id + ") ";
		}
	}
