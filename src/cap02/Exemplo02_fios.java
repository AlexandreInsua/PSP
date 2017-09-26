package cap02;

public class Exemplo02_fios extends Thread {
	public void run() {
		System.out.println(
				"Dentro do fío " + this.getName() + ", prioridade " + this.getPriority() + ", id " + this.getId());

	}

	public static void main(String[] args) {
		Exemplo02_fios h = null;

		for (int i = 0; i < 3; i++) {
			h = new Exemplo02_fios();
			h.setName("Fío " + (i+1));
			h.setPriority(i + 1);
			h.start();
			System.out.println("Información do " + h.getName() + ": " + h.toString());
		}
		System.out.println("3 fíos creados...");
	}
}
