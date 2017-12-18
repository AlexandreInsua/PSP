package cap02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Exemplo04_applet_reloxio extends Applet implements Runnable {
	// fio
	private Thread fio = null;
	// tipo de letra pra a hora
	private Font fonte;
	// mensaxe que vai aparecer na applet
	private String horaActual = "";

	// método de applet
	public void init() {
		// recibe string, estilo e tamaño
		fonte = new Font("Verdana", Font.BOLD, 26);
	}

	// método de Thread
	public void start() {
		if (fio == null) {
			// crea o fío
			fio = new Thread(this);
			// lanzao o fío
			fio.start();
		}
	}

	// método da Thead
	public void run() {
		Thread fioActual = Thread.currentThread();
		while (fio == fioActual) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			horaActual = sdf.format(cal.getTime());
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

	// método da Thread
	public void stop() {
		fio = null;
	}

	// método de applet
	public void paint(Graphics g) {
		g.clearRect(1, 1, getSize().width, getSize().height);
		setBackground(Color.yellow);
		g.setFont(fonte);
		g.drawString(horaActual, 20, 50);
	}
}
