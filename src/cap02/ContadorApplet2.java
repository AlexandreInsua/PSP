package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApplet2 extends Applet implements ActionListener {

	Contador h1 = new Contador();
	// HiloContador h2 = new HiloContador();
	private Thread h = null; // sempre iniciado a null.
	long CONTADOR = 0;
	private boolean parar;
	private Font fuente;
	private Button b1, b2;

	@Override
	public void start() {
	}

	@Override
	public void init() {
		setBackground(Color.white);
		add(b1 = new Button(" Finalizar Fío 1 "));
		b1.addActionListener(this);
		add(b2 = new Button(" Finalizar Fío 2 "));
		b2.addActionListener(this);

		fuente = new Font("Verdana", 13, 26);

	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente);
		g.drawString("Fio 1: " + Long.toString((long) CONTADOR), 40, 100);
		// g.drawString("Fio 2: " +Long.toString((long) CONTADOR), 40, 130);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setLabel("Finalizado 1");
		if (e.getSource() == b1) {
			// o fíon non é nulo e é o que está en funcionamento
			if (h != null && h.isAlive()) {

			} else {
				h = new Contador();
				h.start();
			}
		} else if (e.getSource() == b2) {
			parar = true;
		}
	}

	@Override
	public void stop() {
		h = null;
	}

}
	class Contador extends Thread {
		public void run() {
			parar = false;
			Thread hiloActual = Thread.currentThread();
			h.start();
			while (h == hiloActual && !parar) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				CONTADOR++;
			}

		}
	}

