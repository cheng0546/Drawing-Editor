package EditeurDeDessin;

import java.awt.*;

public class CreateurRectangle implements CreateurDessin {
	
	public Rectangle creerDessin(Color color) {
		return new Rectangle(color);
	}

	public void paintDessinPrevu(Graphics g) {
		g.fillRect(0, 0, 120, 90);
	}
}
