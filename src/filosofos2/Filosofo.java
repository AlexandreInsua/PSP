package filosofos2;

public class Filosofo extends Thread {

	private int id;
	private String nome;
	private Garfo esquerda, dereita;
	private Cadeira c;

	public Filosofo(int id, String nome, Garfo esquerda, Garfo dereita, Cadeira c) {
		this.id = id;
		this.nome = nome;
		this.esquerda = esquerda;
		this.dereita = dereita;
		this.c = c;
	}

	public void run() {
		while (true) {

			try {
				c.colleCadeira(id, nome);
				dereita.colleGarfo(id, nome);
				esquerda.colleGarfo(id, nome);
				System.out.println(nome.toUpperCase() + " está comendo.");
				esquerda.deixaGarfo(id, nome);
				dereita.deixaGarfo(id, nome);
				c.deixaCadeira(id, nome);
				sleep(100);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
