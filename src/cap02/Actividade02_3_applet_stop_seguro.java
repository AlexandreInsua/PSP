package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividade02_3_applet_stop_seguro extends Applet implements ActionListener {

	// INNER CLASS
	class FioContador extends Thread {
		// Atributos
		private int contador;

		// Construtor
		public FioContador(int c) {
			this.contador = c;

		}

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("Excepci�n capturada: " + ie.toString());
				}
				repaint();
				contador++;
			}
		} // Fin de run()

		// M�todo que devolve o valor de contador (e que se pinta no applet)
		public int getContador() {
			return contador;
		} // fin de getContador()
	} // fin de INNER CLASS

	// Referencia aos dous f�os contadores
	private FioContador c1, c2;

	// Referencia aos dous bot�ns do applet
	private Font fonte;
	private Button b1, b2;

	// Como se inicia o Applet
	@Override
	public void init() {
		// Cor de fondo
		setBackground(Color.yellow);
		// Fonte
		fonte = new Font("Verdana", Font.BOLD, 26);
		// Bot�n 1�
		add(b1 = new Button(" Finalizar contador 1 "));
		// e o seu listener
		b1.addActionListener(this);
		// Bot�n 2�
		add(b2 = new Button(" Finalizar contador 2 "));
		// e o seu listener
		b2.addActionListener(this);
	}

	// Cando empeza o aplet, empezan os fios
	public void start() {
		c1 = new FioContador(12);
		c2 = new FioContador(26);
		c1.start();
		c2.start();

	}

	// m�todo que pinta no applet
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1000, 400);
		g.setFont(fonte);
		g.drawString("Fio 1: " + Integer.toString(c1.getContador()), 40, 100);
		g.drawString("Fio 2: " + Integer.toString(c1.getContador()), 40, 150);
	}

	// Listerner
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			c1.stop();
			b1.setLabel("Parado fio 1");

		} else if (e.getSource() == b2) {
			c2.stop();
			b2.setLabel("Parado fio 2");

		}
	}

	// paramos os f�os
	// referenci�molos a nulos para que sexa unha parada segura 
	public void stop() {
		c1 = null;
		c2 = null;
		
		// outra forma � seguir este procedemento:
		// 1� declarar s unha variable booleana pararFio = false;
		// 2� no run while (!pararFio) {...}
		// 3� no stop pararFio = true;
	}
	
}
