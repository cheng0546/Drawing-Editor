package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DessinPrevu extends JPanel {

	int r, g, b;
	int drawingShape;
	
	DessinPrevu (int drawingShape, int r, int g, int b) {
		this.drawingShape = drawingShape;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		g.setColor(new Color(this.r, this.g, this.b));
		System.out.println("shape: " + this.drawingShape);
		System.out.println("red: " + this.r);
		if (this.drawingShape == 0) {
			g.fillRect(0, 0, 90, 60);
		} else if (this.drawingShape == 1) {
			g.fillOval(0, 0, 90, 60);
		} else if (this.drawingShape == 2) {
			g.drawRect(0, 0, 90, 60);
		} else if (this.drawingShape == 3) {
			g.drawOval(0, 0, 90, 60);
		}
	}
}
