package cap02;

public class GruposHilos {
public static void main(String[] args) {
	// Declaraci�n do 1 grupo
	ThreadGroup grupo1 = new ThreadGroup("subGrupo1");
	Thread hilo1 = new Thread(grupo1, "Hilo 1");
	Thread hilo2 = new Thread(grupo1, "Hilo 2");
	
	// Declaraci�n do 2 grupo
	ThreadGroup grupo2 = new ThreadGroup("subGrupo1");
	Thread hilo3 = new Thread(grupo2, "Hilo 3");
	
	
	grupo1 = Thread.currentThread().getThreadGroup();
	
	int AGC = grupo1.activeGroupCount();
	
	System.out.println("Grupo de hilos activo " +  grupo1.getName() + "grupos activos " + AGC);
	
	// Lista a informaci�n dos grupos de f�os.
	grupo1.list();
}
}
