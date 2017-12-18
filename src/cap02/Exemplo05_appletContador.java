package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Exemplo05_appletContador extends Applet implements Runnable, ActionListener {
	private Thread f;
	long CONTADOR = 0;
	private boolean parar;
	private Font fonte;
	// botóns do applet
	private Button b1, b2;

	public void start() {
	}

	// inicio do applet - características do applet
	public void init() {
		setBackground(Color.yellow);
		add(b1 = new Button("Iniciar contador"));
		b1.addActionListener(this);
		add(b2 = new Button("Parar contador"));
		b2.addActionListener(this);
		fonte = new Font("Verdana", Font.BOLD, 26);
	}

	// método que vai correr o fío
	@Override
	public void run() {
		parar = false;
		Thread fioActual = Thread.currentThread();
		while (f == fioActual && !parar) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			CONTADOR++;
		}

	}

	public void paint (Graphics g){
		g.clearRect(0, 0, 400, 400);
		g.setFont(fonte);
		g.drawString(Long.toString(CONTADOR), 80, 100);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setLabel("Continuar");
		if (e.getSource() == b1) {
			if (f != null && f.isAlive()) {
			} else {
				f = new Thread(this);
				f.start();
			}
		} else if (e.getSource() == b2) {
			parar = true;

		}

	}

}
