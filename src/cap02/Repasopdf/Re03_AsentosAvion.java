package cap02.Repasopdf;

public class Re03_AsentosAvion {
	private int asentosLibres = 5;

	public int getAsentosLibres() {
		return asentosLibres;
	}

	public boolean getAsentosLibres(int numPrazas) {
		if (numPrazas <= asentosLibres) {
			return true;
		} else {
			return false;
		}
	}

	public void reservaAsentos(int numAsentosReservados) {
		asentosLibres = asentosLibres - numAsentosReservados;
	}
}
