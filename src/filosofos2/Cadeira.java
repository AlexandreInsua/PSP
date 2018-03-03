package filosofos2;

public class Cadeira {

	private int cLibres = 4;

	public synchronized void colleCadeira(int i, String nome) throws InterruptedException {
		while (cLibres == 0) {
			wait();
		}
		System.out.println("Filósofo " + nome + " colle unha cadeira");
		cLibres--;
	}

	public synchronized void deixaCadeira(int i, String nome) throws InterruptedException {
		cLibres++;
		System.out.println("Filósofo " + nome + " colle unha cadeira");
		notify();
	}
}
