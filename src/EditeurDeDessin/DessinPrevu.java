package EditeurDeDessin;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DessinPrevu extends JPanel {

	Color color;
	CreateurDessin drawingShape;
	
	DessinPrevu(CreateurDessin drawingShape, Color color) {
		this.drawingShape = drawingShape;
		this.color = color;
	}
	
	public void setShape(CreateurDessin drawingShape) {
		this.drawingShape = drawingShape;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.color);
		switch(this.drawingShape.getClass().getName()) {
		case "EditeurDeDessin.CreateurRectangle":
			g.fillRect(0, 0, 120, 90);
			break;
		case "EditeurDeDessin.CreateurElipse":
			g.fillOval(0, 0, 120, 90);
			break;
		case "EditeurDeDessin.CreateurRectangleCreux":
			g.drawRect(0, 0, 120, 90);
			break;
		case "EditeurDeDessin.CreateurElipseCreuse":
			g.drawOval(0, 0, 120, 90);
			break;
		default:
			g.fillRect(0, 0, 120, 90);
			break;
		}
	}
}
