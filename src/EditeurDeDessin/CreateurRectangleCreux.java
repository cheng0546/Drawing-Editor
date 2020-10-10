package EditeurDeDessin;

import java.awt.*;

public class CreateurRectangleCreux implements CreateurDessin {
	
	public RectangleCreux creerDessin(Color color) {
		return new RectangleCreux(color);
	}

	public void paintDessinPrevu(Graphics g) {
		g.drawRect(0, 0, 120, 90);
	}
}
