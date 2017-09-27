package cap02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exemplo03_applet {

	public static void main(String[] args) {

	}

}



class MyApplet extends Applet implements Runnable {
	private Thread thread_applet = null;

	public void init() {
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

		}
		// pra
	}

	public void stop() {
		thread_applet = null;
	}

	public void paint(Graphics g) {
	}
}