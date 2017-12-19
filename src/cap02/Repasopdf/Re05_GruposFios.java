package cap02.Repasopdf;

public class Re05_GruposFios {
public static void main(String[] args) {
	// Declaraci�n do 1 grupo
	ThreadGroup grupo1 = new ThreadGroup("subGrupo1");
	Thread fio1 = new Thread(grupo1, "Fio 1");
	Thread fio2 = new Thread(grupo1, "Fio 2");
	
	// Declaraci�n do 2 grupo
	ThreadGroup grupo2 = new ThreadGroup("subGrupo1");
	Thread fio3 = new Thread(grupo2, "Fio 3");
	
	
	grupo1 = Thread.currentThread().getThreadGroup();
	
	int AGC = grupo1.activeGroupCount();
	
	System.out.println("Grupo de filos activo " +  grupo1.getName() + "grupos activos " + AGC);
	
	// Lista a informaci�n dos grupos de f�os.
	grupo1.list();
}
}
