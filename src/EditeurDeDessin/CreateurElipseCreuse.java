package EditeurDeDessin;

import java.awt.Color;

public class CreateurElipseCreuse implements CreateurDessin {
	
	public ElipseCreuse creerDessin(Color color) {
		return new ElipseCreuse(color);
	}
}