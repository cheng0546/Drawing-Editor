package EditeurDeDessin;

import java.awt.*;

public class CreateurElipse implements CreateurDessin {

	public Elipse creerDessin(Color color) {
		return new Elipse(color);
	}

	public void paintDessinPrevu(Graphics g) {
		g.fillOval(0, 0, 120, 90);
	}
}
