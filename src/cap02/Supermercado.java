package cap02;

import java.applet.Applet;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Supermercado extends Applet {

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		setSize(500,300);
	}
	
	@Override
	public void paint(Graphics g) {
		Caixeiro ca1 = new Caixeiro(1, "Erica", 20,20, g);
		Caixeiro ca2 = new Caixeiro(2, "Miguel",40, 20,g);
		Caixeiro ca3 = new Caixeiro(3, "Xan",60, 20,g);
		Caixeiro ca4 = new Caixeiro(4, "Uxía",80, 20,g);
		
		while (ca1.isAlive()){
			g.drawString("En execución...", 10, 10);
		}
		
		
		
	}
}
