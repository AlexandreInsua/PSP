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

		private String name;

		private int CONTADOR;

		public Contador(String name) {
			this.name = name;

			this.CONTADOR = 0;

			start();
		}

		public int getContador() {
			return CONTADOR;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("Excepción capturada: " + ie.toString());
				}
				CONTADOR++;
			}
		}
	}

	Contador c1, c2;
	private Button b1, b2;
	private Graphics g;
	private Font fuente = new Font("Verdana", 5, 16);;

	@Override
	public void init() {
		setSize(300, 200);
		setBackground(Color.white);

		add(b1 = new Button(" Finalizar 1 "));
		b1.addActionListener(this);
		add(b2 = new Button(" Finalizar 2 "));
		b2.addActionListener(this);
	}

	public void start() {
		Contador c1 = new Contador("Contador 1");
		Contador c2 = new Contador("Contador 2");

	}

	@Override
	public void paint(Graphics g) {
		g.setFont(fuente);
		g.drawString(Integer.toString(c1.getContador()), 50, 20);
		g.drawString(Integer.toString(c1.getContador()), 80, 20);

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
			c1.stop();
		} else if (e.getSource() == b2) {
			b2.setLabel("Parado 2");
			c2.stop();
		}
	}

	public void stop() {
		c1 = null;
		c2 = null;
	}
	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * b1.setLabel("Finalizado 1"); if (e.getSource() == b1) { // o fíon non é nulo
	 * e é o que está en funcionamento if (h != null && h.isAlive()) {
	 * 
	 * } else { h = new Contador(); h.start(); } } else if (e.getSource() == b2) {
	 * parar = true; } }
	 */

	
}
