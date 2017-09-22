package cap02;

public class Exemplo01_fios_v2 {

	public class Fio extends Thread{
		private int c;
		private int hilo;

	public Fio (int hilo) {
		this.hilo = hilo;
		System.out.println("creando o " + hilo);
	}
	}

}
