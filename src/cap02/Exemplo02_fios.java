package cap02;

// Declaración conxunta de fío e main()

// Métodos de información dos métodos

public class Exemplo02_fios extends Thread {
	public void run() {
		System.out.println(
				"Dentro do fío " + this.getName() + ", prioridade " + this.getPriority() + ", id " + this.getId());
	}

	// Main
	public static void main(String[] args) {
		// Reserva espazo en memoria
		Exemplo02_fios h = null;

		for (int i = 0; i < 3; i++) {
			// Instancia o fío
			h = new Exemplo02_fios();
			// Dálle nome ao fío
			h.setName("Fío" + (i + 1));
			// Establece a prioridade (por defecto 5)
			h.setPriority(i + 1);
			// Inicia fíos
			h.start();
			// Mostra info
			System.out.println("Información do " + h.getName() + ": " + h.toString());
		}
		System.out.println("*** 3 fíos creados... ***");
	}
}
