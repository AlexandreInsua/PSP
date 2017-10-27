package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ComprobaAprende02 extends Applet implements ActionListener {

	
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
	
	private HiloContador h1, h2, h3;
	// fuente y botones del applet
	private Font fuente;
	private Button b1, b10, b11, b2, b20,b21, b3, b30, b31, stopAll;
	
	final private int coordX = 50;
	final private int coordY = 150;
	final private int sep = 30;
	
	public void init() {
		setSize(200,500);
		
		setBackground(Color.yellow);
		add(b10 = new Button("++"));
		b10.addActionListener(this);
		add(b1 = new Button("Parar Contador 1"));
		b1.addActionListener(this);
		add(b11 = new Button("--"));
		b11.addActionListener(this);
	
		
		add(b20 = new Button("++"));
		b20.addActionListener(this);
		add(b2 = new Button("Parar Contador 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
		add(b21 = new Button("--"));
		b21.addActionListener(this);
		
		
		add(b30 = new Button("++"));
		b30.addActionListener(this);
		add(b3 = new Button("Parar Contador 3"));
		b3.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
		add(b31 = new Button("--"));
		b31.addActionListener(this);
		
		add(stopAll = new Button("Parar todos"));

	}

	// tengo que plantearme algo si reinicio el applet
	public void start() {
		h1 = new HiloContador(12);
		h1.start();
		h2 = new HiloContador(24);
		h2.start();
		h3 = new HiloContador(48);
		h3.start();
	}


	// que pinto en el applet?
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1000, 1000);
		g.setFont(fuente);
		// g.drawString(Long.toString((long) contador), 80, 100);
		// ponemos los dos contadores
		g.drawString("Fío 1:" +Integer.toString(h1.getContador()), coordX, coordY);
		g.drawString("Fío 2:" +Integer.toString(h2.getContador()), coordX, coordY+sep);
		g.drawString("Fío 3:" +Integer.toString(h3.getContador()), coordX, coordY+sep*2);

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
		
		if (e.getSource()== b10){
			
		}
	}// actionPerformed

	// stop() da ap
	public void stop() {
		h1 = null;
		h2 = null;
	}
	
	

}
