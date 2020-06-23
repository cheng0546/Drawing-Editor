package EditeurDeDessin;

import java.awt.Color;

public class CreateurElipse implements CreateurDessin {

	public Elipse creerDessin(Color color) {
		return new Elipse(color);
	}
}
