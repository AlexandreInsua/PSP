package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApplet extends Applet implements Runnable, ActionListener {

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
		add(b1 = new Button("Iniciar contador"));
		b1.addActionListener(this);
		add(b2 = new Button("Parar contador"));
		b2.addActionListener(this);

		fuente = new Font("Verdana", 13, 26);

	}

	@Override
	public void run() {
		parar = false;
		Thread hiloActual = Thread.currentThread();
		while (h == hiloActual && !parar) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			CONTADOR++;
		}

	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente);
		g.drawString(Long.toString((long) CONTADOR), 80, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setLabel("Continuar");
		if (e.getSource() == b1) {
			// o fíon non é nulo e é o que está en funcionamento
			if (h != null && h.isAlive()) {

			} else {
				h = new Thread(this);
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
