package cap02;

import cap02.Exemplo01_fios_v2.Fio;

public class UsaFilo01_v2 {
	public static void main(String[] args) {
		
		
		Fio f =null;
		
		for (int i=0; i<3; i++) {
			f= new Fio (i+1);
			f.start();
		}
	}

}

class Fio implements Runnable{

	public Fio(int i) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}