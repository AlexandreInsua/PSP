package cap02.Repasopdf;

public class Re05_GruposFios {
public static void main(String[] args) {
	// Declaración do 1 grupo
	ThreadGroup grupo1 = new ThreadGroup("subGrupo1");
	Thread fio1 = new Thread(grupo1, "Fio 1");
	Thread fio2 = new Thread(grupo1, "Fio 2");
	
	// Declaración do 2 grupo
	ThreadGroup grupo2 = new ThreadGroup("subGrupo1");
	Thread fio3 = new Thread(grupo2, "Fio 3");
	
	
	grupo1 = Thread.currentThread().getThreadGroup();
	
	int AGC = grupo1.activeGroupCount();
	
	System.out.println("Grupo de filos activo " +  grupo1.getName() + "grupos activos " + AGC);
	
	// Lista a información dos grupos de fíos.
	grupo1.list();
}
}
