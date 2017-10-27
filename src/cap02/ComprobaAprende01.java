package cap02;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprobaAprende01 extends Applet implements Runnable, ActionListener {

	private Thread h;
	private Font font;
	private boolean stop = false;
	private boolean toRight = true;
	private Button button;
	private String letter = "O";
	private int x = 1;
	private int y = 100;

	public void init() {
		setBackground(Color.YELLOW);
		add(button = new Button("Iniciar rebote"));
		button.addActionListener(this);
		font = new Font("Verdana", Font.BOLD, 26);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			button.setLabel("Continuar");
			if (h != null && h.isAlive()) {
				stop = true;
			
		} else {
			button.setLabel("Parar");
			h = new Thread(this);
			h.start();
		}}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(font);
		g.drawString(letter, x, y);

	}
	
	public void stop(){
		h= null;
	}

	@Override
	public void run() {
		stop = false;
		Thread currentTread = Thread.currentThread();
		while (h == currentTread && !stop) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException iee) {
				iee.printStackTrace();
			}

			if (x < this.getWidth() - 20) {
				repaint();
				x++;
			} else if (x == this.getWidth() - 20) {
				while (x != 0) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					repaint();
					x--;
				}
			}
		}

	}

}