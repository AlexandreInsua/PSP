package cap02.Repasopdf;

// obxecto compartido
/*
 * Esta clase implementa o contador da tirada de dados
 */
class Re02_TiradaDados_multiple {
	
	private int marcador;
	String nome;
	// variable para contar as vitorias
	private int vitorias;
	
	public Re02_TiradaDados_multiple(int i,String n) {
		marcador = i;
		nome=n;
	}

	// getter
	public int getVitorias(){
		return vitorias;
	}
	
	// método que marca o gañador
	public void ganhou(){
		vitorias += 1;
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
