package cap02;

/*
 * Exemplo que para un fio chamando a interrupt e proboca una excepción
 * 
 */
public class Exemplo07_parar_fio_interrupt extends Thread {

	public void run(){
		try {
			while (!isInterrupted()){
				System.out.println("No fío..");
				Thread.sleep(10);
				
			}
		}catch (InterruptedException ie){
			System.out.println("Ocorreu unha excepción");
		}
		
		System.out.println("Fin do fio");
	}
	
	public void interromper(){
		interrupt();
	}
	
	public static void main(String[] args) {
		Exemplo07_parar_fio_interrupt f = new Exemplo07_parar_fio_interrupt();
		f.start();
		
		// bucle para facer algo de tempo
		for (int i = 0; i < 1000000; i++) {
			
		}
		
		f.interromper();
	}
}
