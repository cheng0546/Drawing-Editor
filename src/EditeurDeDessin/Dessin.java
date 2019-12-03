package EditeurDeDessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import EditeurDeDessin.ZoneDeDessin.MyMouseListener;
import EditeurDeDessin.ZoneDeDessin.MyMouseMotionListener;

abstract class Dessin extends JPanel {
	
	int xStart, yStart, xEnd, yEnd;
		
	Rectangle rectangle;
	Elipse elipse;
	CreateurRectangleCreux rectangleCreux;
	ElipseCreuse elipseCreuse;
	
	public Dessin () {
		MyMouseListener myMouseListener = new MyMouseListener();
		addMouseListener(myMouseListener);
		MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener();
		addMouseMotionListener(myMouseMotionListener);
	}
	
	class MyMouseListener implements MouseListener {
				
		@Override
		public void mousePressed (MouseEvent e) {
			xStart = e.getX();
			yStart = e.getY();
			//point = getLocation();
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
			//setSize(w, h);
			setLocation(getLocation().x + (xEnd - xStart), getLocation().y + (yEnd - yStart));
		}
		
		public void mouseMoved (MouseEvent e) {
			
		}
	}
}
