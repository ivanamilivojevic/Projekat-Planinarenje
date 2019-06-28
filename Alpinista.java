package planinarenje;

public class Alpinista extends Planinar {

	private static int V = 3000;
	private Planinar partner;

	public Alpinista(String ime, int kap) {
		super(ime, kap);
	}

	public void dodeli(Planinar p) {
		if (!(p instanceof KlasicniPlaninar))
			partner = p;
	}

	protected boolean penjiSe(Planina p) {
		if (partner != null && p.getVisina() >= V)
			return true;
		else
			return false;
	}

	public String toString() {
		return "A_" + super.toString();
	}
	

}
