package EditeurDeDessin;

public class CreateurElipse implements CreateurDessin {

	public Elipse creerDessin (int r, int g, int b) {
		return new Elipse(r, g, b);
	}
}
