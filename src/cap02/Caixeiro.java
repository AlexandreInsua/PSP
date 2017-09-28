package cap02;

import java.awt.Graphics;

public class Caixeiro extends Thread {
	private int tempo;
	private String name;
	private int coordY;
	Graphics g;
	private int coordX;

	/**
	 * @param tempo
	 * @param name
	 * @param coordY
	 * @param g
	 */
	public Caixeiro(int tempo, String name, int coordX, int coordY, Graphics g) {
		this.tempo = tempo;
		this.name = name;
		this.coordX= coordX;
		this.coordY = coordY;
		
		this.g = g;
		start();
	}

	@Override
	public void run() {
		g.drawString(name,coordY, coordX );
		
		while (true) {
			g.drawString("X",coordY+40, coordX );
			coordY += 12;
			try {
				Thread.sleep(tempo * 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
