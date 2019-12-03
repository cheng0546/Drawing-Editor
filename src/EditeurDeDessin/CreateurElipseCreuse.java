package EditeurDeDessin;

public class CreateurElipseCreuse extends Dessin implements CreateurDessin {
	
	public ElipseCreuse creerDessin (int r, int g, int b) {
		return new ElipseCreuse(r, g, b);
	}
}