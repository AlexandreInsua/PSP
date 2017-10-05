package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Actividade03_ContadorApplet2 extends Applet implements ActionListener {

	// INNER CLASS
	class Contador extends Thread {
		// Atributos
		private int contador;

		// Construtor
		public Contador(int c) {
			this.contador = c;

		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("Excepción capturada: " + ie.toString());
				}
				repaint();
				contador++;
			}
		} // Fin de run()

		// Método que devolve o valor de contador (e que se pinta no applet)
		public int getContador() {
			return contador;
		} // fin de getContador()
	} // fin de INNER CLASS

	// Referencia aos dous fíos contadores
	Contador c1, c2;

	// Referencia aos dous botóns do applet
	private Button b1, b2;

	// Fonde do applet
	private Font fuente;

	// Como se inicia o Applet
	@Override
	public void init() {
		// Cor de fondo
		setBackground(Color.yellow);
		// Fonte
		fuente = new Font("Verdana", Font.BOLD, 26);
		// Botón 1º
		add(b1 = new Button(" Finalizar contador 1 "));
		// e o seu listener
		b1.addActionListener(this);
		// Botón 2º
		add(b2 = new Button(" Finalizar contador 2 "));
		// e o seu listener
		b2.addActionListener(this);
	}

	// Cando empeza o aplet, empezan os fios
	public void start() {
		c1 = new Contador(12);
		c2 = new Contador(26);
		c1.start();
		c2.start();

	}

	// método que pinta no applet
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente);
		g.drawString(Integer.toString(c1.getContador()), 80, 100);
		g.drawString(Integer.toString(c1.getContador()), 80, 150);

		// liñas de probas
		while (c1.isAlive() || c2.isAlive())
			g.drawString("Funcionado", 150, 180);

	}

	// Listerner
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			c1.stop();
			b1.setLabel("Parado 1");

		} else if (e.getSource() == b2) {
			c2.stop();
			b2.setLabel("Parado 2");

		}
	}

	// paramos os fíos
	public void stop() {
		c1 = null;
		c2 = null;
	}
	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * b1.setLabel("Finalizado 1"); if (e.getSource() == b1) { // o fíon non é
	 * nulo e é o que está en funcionamento if (h != null && h.isAlive()) {
	 * 
	 * } else { h = new Contador(); h.start(); } } else if (e.getSource() == b2)
	 * { parar = true; } }
	 */

}
