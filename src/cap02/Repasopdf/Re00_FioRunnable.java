package cap02.Repasopdf;

public class Re00_FioRunnable implements Runnable {

	String strImprimir;

	public Re00_FioRunnable(String strImprimir) {
		this.strImprimir = strImprimir;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(strImprimir + " " + i);
		}
	}

	public static void main(String[] args) {
		// Instanciamos os obxecto instanciable
		Re00_FioRunnable obxectoRunnable1 = new Re00_FioRunnable("Fio 1");
		Re00_FioRunnable obxectoRunnable2 = new Re00_FioRunnable("Fio 2");
	
		// creamos 2 fios e pasámoslle como argumento os obxectos anteriores
		
		Thread primeiro = new Thread(obxectoRunnable1);
		Thread segundo = new Thread(obxectoRunnable2);
		
		// iniciamos os fíos
		primeiro.start();
		segundo.start();
		System.out.println("Fin main");
	}
}
