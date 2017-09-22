package cap02;

public class HiloExjemplo2 extends Thread {
	public void run() {
		System.out.println("desde o fio " + this.getName()+
			 ", prioridade" + this.getPriority()+ ", id " + this.getId());
		
		
	}

	public static void main(String[] args) {
		HiloExjemplo2 h = null;
		
		for (int i = 0; i < 3; i++) {
			h = new HiloExjemplo2();
			h.setName("hilo" + i);
			
			
		}
	}
}
