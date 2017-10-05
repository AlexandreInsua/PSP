package cap02;

// Declaraci�n conxunta de f�o e main()

// M�todos de informaci�n dos m�todos

public class Exemplo02_fios extends Thread {
	public void run() {
		System.out.println(
				"Dentro do f�o " + this.getName() + ", prioridade " + this.getPriority() + ", id " + this.getId());
	}

	// Main
	public static void main(String[] args) {
		// Reserva espazo en memoria
		Exemplo02_fios h = null;

		for (int i = 0; i < 3; i++) {
			// Instancia o f�o
			h = new Exemplo02_fios();
			// D�lle nome ao f�o
			h.setName("F�o" + (i + 1));
			// Establece a prioridade (por defecto 5)
			h.setPriority(i + 1);
			// Inicia f�os
			h.start();
			// Mostra info
			System.out.println("Informaci�n do " + h.getName() + ": " + h.toString());
		}
		System.out.println("*** 3 f�os creados... ***");
	}
}
