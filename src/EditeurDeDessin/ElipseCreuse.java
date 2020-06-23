package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;

public class ElipseCreuse extends Dessin {
	
	Color color;
	
	ElipseCreuse(Color color) {
		this.color = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.color);
		g.drawOval(0, 0, getWidth()-1, getHeight()-1);
	}
}
