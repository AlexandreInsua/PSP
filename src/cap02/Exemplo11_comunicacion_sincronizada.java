package cap02;

/*
 * A comunicaci�n entre f�os real�zase compartindo un obxecto. Para evitar 
 * a desincron�a implementamos unha t�cnica para sincronizar o c�digo. 
 * Isto fai que primiero corra un f�o e despois outro
 */
public class Exemplo11_comunicacion_sincronizada {

	public static void main(String[] args) {
		ContadorS contador = new ContadorS(100);
		FioAs a = new FioAs("Fio A s", contador);
		FioBs b = new FioBs("Fio B s", contador);
		a.start();
		b.start();

	}
}

// obxecto compartido
class ContadorS {
	private int c;

	public ContadorS(int c) {
		super();
		this.c = c;
	}

	public void incrementa() {
		c += 1;
	}

	public void decrementa() {
		c -= 1;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}

// D�as clases que extenden Thread
// FioA incrementa o valor
class FioAs extends Thread {
	private ContadorS contador;

	public FioAs(String nome, ContadorS contador) {
		setName(nome);
		this.contador = contador;
	}

	public void run() {
		// o obxecto est� sincronizado - d�bese evitar
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.incrementa();
				System.out.println(getName() + " contador vale " + contador.getC());
			}
		}
	}

}

// FioB decrementa o valor
class FioBs extends Thread {
	private ContadorS contador;

	public FioBs(String nome, ContadorS contador) {
		setName(nome);
		this.contador = contador;
	}

	public void run() {
		// o obxecto est� sincronizado - d�bese evitar
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.decrementa();
				System.out.println(getName() + " contador vale " + contador.getC());
			}
		}
	}
}