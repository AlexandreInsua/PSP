package cap02;

// Declaraci�n conxunta de f�o e main()

// M�todos de informaci�n dos m�todos

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
			// Instancia o f�o
			f = new Exemplo02_fios();
			// D�lle nome ao f�o
			f.setName("F�o " + (i + 1));
			// Establece a prioridade (por defecto 5)
			f.setPriority(i + 1);
			// Inicia f�os
			f.start();
			// Mostra info
			System.out.println("Informaci�n do " + f.getName() + ": " + f.toString());
		}
		System.out.println("*** 5 f�os creados... ***");
	}
}
