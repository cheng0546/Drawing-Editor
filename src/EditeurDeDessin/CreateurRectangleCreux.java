package EditeurDeDessin;

public class CreateurRectangleCreux implements CreateurDessin {
	
	public RectangleCreux creerDessin (int r, int g, int b) {
		return new RectangleCreux(r, g, b);
	}
}
