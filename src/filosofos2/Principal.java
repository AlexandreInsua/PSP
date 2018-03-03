package filosofos2;

public class Principal {

	public static void main(String[] args) {
		
		Cadeira c =new Cadeira();

		String[] nomesFilosofos = { "Platón", "Aristóteles", "Maquiavelo", "Descartes", "Marx" };

		Garfo[] garfos = new Garfo[5];

		for (int i = 0; i < garfos.length; i++) {
			garfos[i] = new Garfo(i);
		}

		Filosofo[] filosofos = new Filosofo[5];

		for (int i = 0; i < filosofos.length; i++) {

			filosofos[i] = new Filosofo(i, nomesFilosofos[i], garfos[i], garfos[(i + 1) % 5], c);
		}

		for (int i = 0; i < filosofos.length; i++) {

			filosofos[i].start();
		}
	}

}
