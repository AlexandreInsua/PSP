package filosofos2;

public class Garfo {
	private int id;
	private boolean libre = true;

	public Garfo(int id) {

	}

	public synchronized void colleGarfo(int i, String nome) throws InterruptedException {
		while (!libre) {
			wait();
		}
		System.out.println("O filosofo " + nome + " colle o garfo " + id);
		libre = false;
	}

	public synchronized void deixaGarfo(int i, String nome) {
		libre = true;
		System.out.println("O filosofo " + nome + " deixa o garfo " + id);
	}
}
