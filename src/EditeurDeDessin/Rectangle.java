package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Dessin {
	
	Color color;
	
	Rectangle(Color color) {
		this.color = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillRect(0, 0, getWidth()-1, getHeight()-1);
	}
}
