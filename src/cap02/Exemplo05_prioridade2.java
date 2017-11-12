package cap02;

public class Exemplo05_prioridade2 extends Thread{
	
	Exemplo05_prioridade2(String nome){
		this.setName(nome);
	}
	public void run(){
		System.out.println("Executando ["+getName()+"]");
		for (int i = 1; i<=5;i++){
			System.out.println("\t("+getName()+": " + i + ")");
		}
	}

	public static void main(String[] args){
		Exemplo05_prioridade2 fio1 = new Exemplo05_prioridade2("Un");
		Exemplo05_prioridade2 fio2 = new Exemplo05_prioridade2("Dous");
		Exemplo05_prioridade2 fio3 = new Exemplo05_prioridade2("Tres");
		Exemplo05_prioridade2 fio4 = new Exemplo05_prioridade2("Catro");
		Exemplo05_prioridade2 fio5 = new Exemplo05_prioridade2("Cinco");
		
		// Asignamos a prioridade
		fio1.setPriority(MIN_PRIORITY);
		fio2.setPriority(3);
		fio3.setPriority(NORM_PRIORITY);
		fio4.setPriority(7);
		fio5.setPriority(MAX_PRIORITY);
		
		// Executamos
		fio1.start();
		fio2.start();
		fio3.start();
		fio4.start();
		fio5.start();
		
	}
}
