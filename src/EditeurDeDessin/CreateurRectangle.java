package EditeurDeDessin;

import java.awt.Color;

public class CreateurRectangle implements CreateurDessin {
	
	public Rectangle creerDessin(Color color) {
		return new Rectangle(color);
	}

}
