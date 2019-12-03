package EditeurDeDessin;

public class CreateurRectangle extends Dessin implements CreateurDessin {
	
	public Rectangle creerDessin (int r, int g, int b) {
		return new Rectangle(r, g, b);
	}

}
