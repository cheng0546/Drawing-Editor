package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {
	
	int xStart, yStart, xEnd, yEnd;
	Dessin dessin;
	MyMouseListener myMouseListener;
	
	public ZoneDeDessin () {
		myMouseListener = new MyMouseListener();
		addMouseListener(myMouseListener);
		MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener();
		addMouseMotionListener(myMouseMotionListener);
	}
	
	public void defineShape (CreateurDessin createurDessin) {
		myMouseListener.setShape(createurDessin);
	}
	
	public void defineColor (int r, int g, int b) {
		myMouseListener.setColor(r, g, b);
	}
	
	class MyMouseListener implements MouseListener {
		
		CreateurDessin createurDessin;
		int r, g, b;
		
		public void setShape (CreateurDessin createurDessin) {
			this.createurDessin = createurDessin;
		}
		
		public void setColor (int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
		
		@Override
		public void mousePressed (MouseEvent e) {
			xStart = e.getX();
			yStart = e.getY();
			dessin = this.createurDessin.creerDessin(this.r, this.g, this.b);
			dessin.setOpaque(false);
			add(dessin);
		}
		
		@Override
		public void mouseClicked (MouseEvent e) {

		}
		
		public void mouseReleased (MouseEvent e) {
			
		}
			
		public void mouseEntered (MouseEvent e) {
			
		}
		
		public void mouseExited (MouseEvent e) {
			
		}
	}
		
	class MyMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseDragged (MouseEvent e) {
			xEnd = e.getX();
			yEnd = e.getY();
			dessin.setBounds(xStart, yStart, xEnd-xStart, yEnd-yStart);
		}
		
		public void mouseMoved (MouseEvent e) {
			
		}
	}
}
