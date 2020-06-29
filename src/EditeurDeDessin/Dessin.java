package EditeurDeDessin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

abstract class Dessin extends JPanel {
	
	int xStart, yStart, xEnd, yEnd;
	int width, height;
	Rectangle rectangle;
	Elipse elipse;
	CreateurRectangleCreux rectangleCreux;
	ElipseCreuse elipseCreuse;
	
	public Dessin() {
		MyMouseListener myMouseListener = new MyMouseListener(this);
		addMouseListener(myMouseListener);
		MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener();
		addMouseMotionListener(myMouseMotionListener);
		MyMouseWheelListener myMouseWheelListener = new MyMouseWheelListener(this);
		addMouseWheelListener(myMouseWheelListener);
	}
	
	public void enlargeDessin() {
		if (getWidth() >= 670) {
			return;
		}
		if (getHeight() >= 510) {
			return;
		}
		setSize(getWidth() + getWidth() / 10, getHeight() + getHeight() / 10);
		repaint();
	}
	
	public void reduceDessin() {
		if (getWidth() <= 20) {
			return;
		}
		if (getHeight() <= 10) {
			return;
		}
		setSize(getWidth() - getWidth() / 10, getHeight() - getHeight() / 10);
		repaint();
	}
	
	class MyMouseListener implements MouseListener {
		
		Dessin dessin;
		
		MyMouseListener(Dessin dessin) {
			this.dessin = dessin;
		}
				
		@Override
		public void mousePressed(MouseEvent e) {
			xStart = e.getX();
			yStart = e.getY();
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
			setLocation(getLocation().x + (xEnd - xStart), getLocation().y + (yEnd - yStart));
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}
	}
	
	class MyMouseWheelListener implements MouseWheelListener {
		Dessin dessin;
		public MyMouseWheelListener(Dessin dessin) {
			this.dessin = dessin;
		}
		
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (e.getWheelRotation() < 0) {
				dessin.enlargeDessin();
			}
			else {
				dessin.reduceDessin();
			}
		}
	}

}
