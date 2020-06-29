package EditeurDeDessin;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {
	
	int xStart, yStart, xEnd, yEnd;
	Dessin dessin;
	MyMouseListener myMouseListener;
	Color color;
	
	public ZoneDeDessin() {
		myMouseListener = new MyMouseListener();
		addMouseListener(myMouseListener);
		MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener();
		addMouseMotionListener(myMouseMotionListener);
	}
	
	public void defineShape(CreateurDessin createurDessin) {
		myMouseListener.setShape(createurDessin);
	}
	
	public void defineColor(Color color) {
		myMouseListener.setColor(color);
	}
	
	class MyMouseListener implements MouseListener {
		
		CreateurDessin createurDessin;
		Color color;
		
		public void setShape(CreateurDessin createurDessin) {
			this.createurDessin = createurDessin;
		}
		
		public void setColor(Color color) {
			this.color = color;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			xStart = e.getX();
			yStart = e.getY();
			dessin = this.createurDessin.creerDessin(this.color);
			dessin.setOpaque(false);
			add(dessin);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {

		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
			
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
	}
		
	class MyMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			xEnd = e.getX();
			yEnd = e.getY();
			dessin.setBounds(Math.min(xStart, xEnd), Math.min(yStart, yEnd), Math.abs(xEnd-xStart), Math.abs(yEnd-yStart));
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}
	}
}
