package cap02.Repasopdf;

/* 
 * Con esta configuración non se sincroniza a xestion de asentos.
 */

public class Re03_AxenciasViaxes implements Runnable {
	private Re03_AsentosAvion aa = new Re03_AsentosAvion();

	public void run() {
		xestionAsentosAvion(3);
		if (aa.getAsentosLibres() <= 0) {
			System.out.println("Non hai asentos libres");
		}
	}

	public void xestionAsentosAvion(int numAsentosReservados) {
		if (aa.getAsentosLibres() >= numAsentosReservados) {
			System.out.println(
					Thread.currentThread().getName() + " vai facer unha reseva de " + numAsentosReservados +  " prazas");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			aa.reservaAsentos(numAsentosReservados);
			System.out.println(Thread.currentThread().getName()
					+ " Reserva realizada con éxito.\nAs prazas libres son " + aa.getAsentosLibres());
		} else {
			System.out.println("non hai prazas suficientes para o cliente. " + Thread.currentThread().getName()
					+ " As prazas libres son: " + aa.getAsentosLibres());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
		}
	}
	
	public static void main(String[] args) {
		Re03_AxenciasViaxes axencia = new Re03_AxenciasViaxes();
		
		// Están a compartir a mesma axencia
		Thread fio1 = new Thread(axencia);
		Thread fio2 = new Thread(axencia);
		
		fio1.setName("Cliente 1");
		fio2.setName("Cliente 2");
		
		fio1.start();
		fio2.start();
		
	}

}