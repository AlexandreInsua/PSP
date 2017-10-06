package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Actividade03_Applet2_ extends Applet implements ActionListener {

	
	class HiloContador extends Thread {
		boolean stopFio = true;
		private int contador;

		HiloContador(int c) {
			this.contador = c;
		}

		public void run() {
			while (stopFio) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					System.out.println("excepcion capturada");
					ex.printStackTrace();
				}
				repaint();
				contador++;
			}
		}// fin del run

		public int getContador() {
			return contador;
		}
		// Cambia 
		public void pararFio() {
			stopFio = false;
		}

	}// clase interna que prepara los dos hilos (o mas)

	// atributos de la clase principal
	private HiloContador h1, h2;
	// fuente y botones del applet
	private Font fuente;
	private Button b1, b2;

	public void init() {
		setSize(500,200);
		setBackground(Color.yellow);
		add(b1 = new Button("Parar Contador 1"));
		b1.addActionListener(this);
		add(b2 = new Button("Parar Contador 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);

	}

	// tengo que plantearme algo si reinicio el applet
	public void start() {
		h1 = new HiloContador(12);
		h1.start();
		h2 = new HiloContador(26);
		h2.start();
	}


	// que pinto en el applet?
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1000, 1000);
		g.setFont(fuente);
		// g.drawString(Long.toString((long) contador), 80, 100);
		// ponemos los dos contadores
		g.drawString("Fío 1:" +Integer.toString(h1.getContador()), 180, 100);
		g.drawString("Fío 2:" +Integer.toString(h2.getContador()), 180, 150);

	}

	// control de eventos osbre los botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			// Chama ao método que cambia o booleano
			h1.pararFio();
			b1.setLabel("HILO 1 FINALIZADO");
		}
		

		else {
			// paramos el hilo y renombramos el boton
			h2.pararFio();
			b2.setLabel("HILO 2 FINALIZADO");
		}
	}// actionPerformed

	// stop() da ap
	public void stop() {
		h1 = null;
		h2 = null;
	}

}
