package cap02;

/*
 * Exemplo que mostra a sincronizaci�n de m�todos - recomendada.
 */
public class Exemplo12_Conta_sincronizada {

	public static void main(String[] args) {
		Conta c = new Conta(400);

		SacarDinheiro f1 = new SacarDinheiro("Ana", c);
		SacarDinheiro f2 = new SacarDinheiro("Breog�n", c);

		f1.start();
		f2.start();

	}
}

/*
 * 
 * Conta - clase compartida Define un atributo saldo e tres m�todos: un devolve
 * valor, outro resta unha cantidade ao saldo e o terceiro que verifica a
 * retirada de di�eiro
 */
class Conta {
	private int saldo;

	// o construtor ten a o saldo inicial como par�metro
	Conta(int saldo) {
		this.saldo = saldo;
	}

	int getSaldo() {
		return saldo;
	}

	void restar(int cantidade) {
		saldo = saldo - cantidade;
	}

	/* sincronizamos o m�todo retirar di�eiro. As�, se un f�o est� a usalo,
	 * ning�n outro poder� usalo.
	 */
	synchronized void retirardinheiro(int cantidade, String nome) {
		if (getSaldo() >= cantidade) {
			System.out.println("vaise retirar " + cantidade + ". Saldo actual: " + getSaldo());

			try {
				Thread.sleep(1);
			} catch (InterruptedException ie) {
			}
			restar(cantidade);
			System.out.println(nome + " retira " + cantidade + ". Saldo actual: " + getSaldo());

		} else {
			System.out.println(nome + " non pode retirar o di�eiro, NON HAI SALDO. Saldo actual: " + getSaldo());
		}
		if (getSaldo() < 0) {
			System.err.println("Saldo negativo: " + getSaldo());
		}
	}
}

// fio que saca o di�eiro
// o f�o recibe ten como par�mtros o nome e unha conta
class SacarDinheiro extends Thread {
	private Conta c;
	String nome;

	public SacarDinheiro(String nome, Conta c) {
		super(nome);
		this.c = c;
	}

	public void run() {
		for (int i = 0; i <= 20; i++) {
			c.retirardinheiro(10, getName());
		}
	}

}