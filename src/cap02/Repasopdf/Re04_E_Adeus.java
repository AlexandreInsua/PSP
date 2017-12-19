package cap02.Repasopdf;

public class Re04_E_Adeus implements Runnable{
	Re04_Pizarra piz;

	Re04_E_Adeus(Re04_Pizarra piz){
	this.piz = piz;
		new Thread(this, "Adeus").start();		
	}
	
	public void run(){
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				piz.eAdeus();
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
