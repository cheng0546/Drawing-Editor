package EditeurDeDessin;

public class CreateurElipseCreuse implements CreateurDessin {
	
	public ElipseCreuse creerDessin (int r, int g, int b) {
		return new ElipseCreuse(r, g, b);
	}
}