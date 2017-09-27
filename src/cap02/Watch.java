package cap02;

import java.applet.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Watch extends Applet implements Runnable {
	
	
	
	private Thread thread_applet = null;
	private Font font;
	private String nowHore = "";

	public void init() {
		font = new Font("Verdana", Font.BOLD, 26);
	}

	public void start() {
		if (thread_applet == null) {
			// crea o fico
			thread_applet = new Thread(this);
			thread_applet.start();
		}
	}

	public void run() {
		Thread actualThreat = Thread.currentThread();
		while (thread_applet == actualThreat) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			nowHore = sdf.format(cal.getTime());
			repaint();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
			}
		}
	}

	public void paint(Graphics g) {
		g.clearRect(1, 1, getSize().width, getSize().height);
		setBackground(Color.yellow);
		g.setFont(font);
		g.drawString(nowHore, 20, 50);
	}

	public void stop() {
		thread_applet = null;
	}
}
