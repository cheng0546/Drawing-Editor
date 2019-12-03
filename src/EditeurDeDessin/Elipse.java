package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Dessin {
	
	int r, g, b;
	
	Elipse (int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		g.setColor(new Color(this.r, this.g, this.b));
		g.fillOval(0, 0, getWidth()-1, getHeight()-1);
	}
}
