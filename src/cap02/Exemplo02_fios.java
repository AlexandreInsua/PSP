package cap02;

// Declaración conxunta de fío e main()

// Métodos de información dos métodos

// Devolve a prioridade

public class Exemplo02_fios extends Thread {
	public void run() {
		System.out.println(
				"Dentro do " + this.getName() + ", prioridade " + this.getPriority() + ", id " + this.getId());
	}

	// Main
	public static void main(String[] args) {
		// Reserva espazo en memoria
		Exemplo02_fios f = null;

		for (int i = 0; i < 10; i++) {
			// Instancia o fío
			f = new Exemplo02_fios();
			// Dálle nome ao fío
			f.setName("Fío " + (i + 1));
			// Establece a prioridade (por defecto 5)
			f.setPriority(i + 1);
			// Inicia fíos
			f.start();
			// Mostra info
			System.out.println("Información do " + f.getName() + ": " + f.toString());
		}
		System.out.println("*** 5 fíos creados... ***");
	}
}
