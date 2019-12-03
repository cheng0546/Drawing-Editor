package EditeurDeDessin;

public class CreateurRectangleCreux extends Dessin implements CreateurDessin {
	
	public RectangleCreux creerDessin (int r, int g, int b) {
		return new RectangleCreux(r, g, b);
	}
}
