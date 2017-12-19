package cap02;

/*
 * Exemplo que mostra a sincronización de métodos - recomendada.
 */
public class Exemplo12_Conta_sincronizada {

	public static void main(String[] args) {
		Conta c = new Conta(400);

		SacarDinheiro f1 = new SacarDinheiro("Ana", c);
		SacarDinheiro f2 = new SacarDinheiro("Breogán", c);

		f1.start();
		f2.start();

	}
}

/*
 * 
 * Conta - clase compartida Define un atributo saldo e tres métodos: un devolve
 * valor, outro resta unha cantidade ao saldo e o terceiro que verifica a
 * retirada de diñeiro
 */
class Conta {
	private int saldo;

	// o construtor ten a o saldo inicial como parámetro
	Conta(int saldo) {
		this.saldo = saldo;
	}

	int getSaldo() {
		return saldo;
	}

	void restar(int cantidade) {
		saldo = saldo - cantidade;
	}

	/* sincronizamos o método retirar diñeiro. Así, se un fío está a usalo,
	 * ningún outro poderá usalo.
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
			System.out.println(nome + " non pode retirar o diñeiro, NON HAI SALDO. Saldo actual: " + getSaldo());
		}
		if (getSaldo() < 0) {
			System.err.println("Saldo negativo: " + getSaldo());
		}
	}
}

// fio que saca o diñeiro
// o fío recibe ten como parámtros o nome e unha conta
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