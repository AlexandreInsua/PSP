package cap02;

/*
 * A comunicación entre fios realízase a través dun obxecto partillado entre eles.
 * Este exemplo demostra que o comportamento dos fíos non está sincronizado e 
 * a secuencia agardada 101, 100, 101, 100 ... pode varias por que non están 
 * sincronizados.
 */
public class Exemplo10_comunicacion {

	// O main proba o exemplo
	public static void main(String[] args) {
		Contador contador = new Contador(100);
		FioA a = new FioA("Fio A", contador);
		FioB b = new FioB("Fio B", contador);
		a.start();
		b.start();

	}
}

/*
 * A clase define un atributo contador e tres métods, un incrementa o seu valor,
 * outro o decrementa e outro devolve o valor
 */
class Contador {
	private int c;

	public Contador(int c) {
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
class FioA extends Thread {
	private Contador contador;

	public FioA(String nome, Contador contador) {
		setName(nome);
		this.contador = contador;
	}

	public void run() {
		for (int i = 0; i < 300; i++) {
			contador.incrementa();
			System.out.println(getName() + " contador vale " + contador.getC());
		}

	}

}

// FioB decrementa o valor
class FioB extends Thread {
	private Contador contador;

	public FioB(String nome, Contador contador) {
		setName(nome);
		this.contador = contador;
	}

	public void run() {
		for (int i = 0; i < 300; i++) {
			contador.decrementa();
			System.out.println(getName() + " contador vale " + contador.getC());
		}

	}
}