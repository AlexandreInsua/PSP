package cap02;

/*
 * A comunicación entre fíos realízase compartindo un obxecto. Para evitar 
 * a desincronía implementamos unha técnica para sincronizar o código. 
 * Isto fai que primiero corra un fío e despois outro
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

// Dúas clases que extenden Thread
// FioA incrementa o valor
class FioAs extends Thread {
	private ContadorS contador;

	public FioAs(String nome, ContadorS contador) {
		setName(nome);
		this.contador = contador;
	}

	public void run() {
		// o obxecto está sincronizado - débese evitar
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
		// o obxecto está sincronizado - débese evitar
		synchronized (contador) {
			for (int i = 0; i < 300; i++) {
				contador.decrementa();
				System.out.println(getName() + " contador vale " + contador.getC());
			}
		}
	}
}