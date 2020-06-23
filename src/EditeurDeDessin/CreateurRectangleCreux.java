package EditeurDeDessin;

import java.awt.Color;

public class CreateurRectangleCreux implements CreateurDessin {
	
	public RectangleCreux creerDessin(Color color) {
		return new RectangleCreux(color);
	}
}
