package filosofos;

import java.util.Random;

public class Filosofo extends Thread {
	private int tempo_comendo, tempo_pensando;
	private Mesa mesa;
	private Random random;
	private int id;
	private String nome;
	
	public Filosofo(int tempo_comendo, int tempo_pensando, Mesa mesa, Random random, int id, String nome) {
		super();
		this.tempo_comendo = tempo_comendo;
		this.tempo_pensando = tempo_pensando;
		this.mesa = mesa;
		this.random = random;
		this.id = id;
		this.nome = nome;
	}
	
	public void espera(int tempo) throws InterruptedException {
		int t = random.nextInt(tempo);
		sleep(t);
	}
	
	public void pensa (int i, int tempo_pensando) {
		
	}
	public void come(int i, int tempo) throws InterruptedException {
		System.out.println("O filosofo " + nome + " empeza a comer.");
		espera(tempo);
		System.out.println("O filosofo " + nome + " acaba de comer");
	}

	public void ciclo()
	{
		pensa(id,tempo_pensando);
		mesa.pideTenedores(id);
		come(id, tempo_comendo);
		mesa.cedeTenedores(id);
	}
	
	
}
