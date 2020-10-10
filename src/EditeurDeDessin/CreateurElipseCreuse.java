package EditeurDeDessin;

import java.awt.*;

public class CreateurElipseCreuse implements CreateurDessin {
	
	public ElipseCreuse creerDessin(Color color) {
		return new ElipseCreuse(color);
	}

	public void paintDessinPrevu(Graphics g) {
		g.drawOval(0, 0, 120, 90);
	}
}