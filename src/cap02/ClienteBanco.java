package cap02;

public class ClienteBanco extends Thread {

	/*
	 * É necesario incluir o obxecto que se vai comporatir como atributo dos
	 * clientes para poder pasarse a mesma conta que implementará os seus métodos
	 * propios
	 */
	Cuenta cuenta;
	String nombre;

	public ClienteBanco(Cuenta cuenta, String nombre) {
		this.nombre = nombre;
		this.cuenta = cuenta;
	}

	public void start() {
	}

	public void run() {
int demora = 200;
		
		try {
			cuenta.ingreso(numeroAleatorio(), nombre);
			cuenta.reintegro(numeroAleatorio(), nombre);
			sleep(demora);
		} catch (Exception e) {
			System.err.println("Fatal error");
		}

	}

	public int numeroAleatorio() {
		int numero = (int) (Math.random() * (500 + 1));
		return numero;
	}

	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(500, 25000);
		ClienteBanco p1 = new ClienteBanco(cuenta, "Mr Pink");
		ClienteBanco p2 = new ClienteBanco(cuenta, "Mr Yellow");
		ClienteBanco p3 = new ClienteBanco(cuenta, "Mr Brown");
		ClienteBanco p4 = new ClienteBanco(cuenta, "Mr Blue");
		ClienteBanco p5 = new ClienteBanco(cuenta, "Mr black");

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();

		p1.run();
		p2.run();
		p3.run();
		p4.run();
		p5.run();

	}
}
