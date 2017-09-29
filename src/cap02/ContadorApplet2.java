package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApplet2 extends Applet implements ActionListener {

	// INNER CLASS
	class Contador extends Thread {
		private boolean parar;
		private String name;
		private int coordX;
		private int coordY;
		private int CONTADOR;
		Graphics g;

		public Contador(String name, int coordX, int coordY, int CONTADOR, Graphics g) {
			this.name = name;
			this.coordX = coordX;
			this.coordY = coordY;
			this.CONTADOR = CONTADOR;
			this.g = g;
			start();
		}

		@Override
		public void run() {
			g.drawString(name, coordY, coordX);
			while (true) {
				int i = 0;
				g.drawString(Integer.toString(CONTADOR), coordY + 100 + i, coordX);
				CONTADOR++;
				i += 10;

				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					System.out.println(ie.toString());
				}

			}
		}
	}

	// private boolean parar;
	private Font fuente = new Font("Verdana", 5, 16);;
	private Button b1, b2;
	private Graphics g;
	Contador c1, c2;

	Thread h = null;

	@Override
	public void init() {
		setSize(300, 200);
		setBackground(Color.white);
		// TODO arranxar isto
		add(c1=new Contador("Contador 1", 50, 20, 0, g));
		add(c2= new Contador("Contador 2", 80, 20, 0, g));

		add(b1 = new Button(" Finalizar 1 "));
		b1.addActionListener(this);
		add(b2 = new Button(" Finalizar 2 "));
		b2.addActionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		g.setFont(fuente);
		
		
		while (c1.isAlive() || c2.isAlive())
			g.drawString("Funcionado", 150, 180);

	}

	public void repaint() {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			b1.setLabel("Parado 1");
			h.stop();
		} else if (e.getSource() == b2) {
			b2.setLabel("Parado 2");
			h.stop();
		}
	}

	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * b1.setLabel("Finalizado 1"); if (e.getSource() == b1) { // o fíon non é nulo
	 * e é o que está en funcionamento if (h != null && h.isAlive()) {
	 * 
	 * } else { h = new Contador(); h.start(); } } else if (e.getSource() == b2) {
	 * parar = true; } }
	 */

	public void stop() {

	}
}
