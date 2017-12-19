package cap02.Repasopdf;

// obxecto compartido
/*
 * Esta clase implementa o contador da tirada de dados
 */
class Re01_TiradaDados {
	
	private int marcador;
	String nome;
	public Re01_TiradaDados(int i,String n) {
		marcador = i;
		nome=n;
	}

	public String getNombre() {
		return nome;
	}
	public synchronized int getSumaMarcador() {
		return marcador;
	}

	public synchronized void setSumaMarcador(int i) {
		marcador += i;
	}
}
