package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Dessin {
	
	Color color;
	
	Elipse(Color color) {
		this.color = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.color);
		g.fillOval(0, 0, getWidth()-1, getHeight()-1);
	}
}
