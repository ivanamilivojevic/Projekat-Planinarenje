package planinarenje;

public class KlasicniPlaninar extends Planinar {
	private static int V = 2000;

	public KlasicniPlaninar(String ime, int kap) {
		super(ime, kap);
	}

	protected boolean penjiSe(Planina p) {
		if (p.getVisina() < V)
			return true;
		else
			return false;
	}

	public String toString() {
		return "K_" + super.toString();
	}

}
