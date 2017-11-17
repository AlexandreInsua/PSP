package cap02.Repasopdf;

import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;

public class AxenciaViaxes implements Runnable {
	// private
	static AsentosAvion asentos = new AsentosAvion();

	public static void main(String[] args) {
		Thread fio1 = new Thread();
		Thread fio2 = new Thread();
		fio1.setName("Cliente 1");
		fio2.setName("Cliente 2");
		fio1.start();
		fio2.start();
	}

	@Override
	public void run() {
		xestionAsentosAvion(3);
		if (asentos.getAsentosLibres() <= 0)
			System.out.println("Non hai asentos libres");

	}

	public static void xestionAsentosAvion(int numAsentosReservados) {
		if (asentos.getAsentosLibres() >= numAsentosReservados) {
			System.out.println(
					Thread.currentThread().getName() + "vai facer unha reseva de " + numAsentosReservados + "prazas");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			asentos.reservaAsentos(numAsentosReservados);
			System.out.println(Thread.currentThread().getName()
					+ " Reserva realiziada con éxito.\nAs prazsa libres son " + asentos.getAsentosLibres());
		} else {
			System.out.println("non hai prazas suficientes para o cliente. " + Thread.currentThread().getName()
					+ "As prazas libres son: " + asentos.getAsentosLibres());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
		}
	}

}

class AsentosAvion {
	private int asentosLibres = 5;

	public int getAsentosLibres() {

		return asentosLibres;
	}

	public boolean getAsentosLibres(int numPrazas) {
		if (numPrazas <= asentosLibres)
			return true;
		else
			return false;
	}

	public void reservaAsentos(int numAsentosReservados) {
		asentosLibres = asentosLibres - numAsentosReservados;
	}

}