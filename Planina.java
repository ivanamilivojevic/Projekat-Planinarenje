package planinarenje;

public class Planina {
	private String ime;
	private int visina;

	public Planina(String ime, int visina) {
		this.ime = ime;
		this.visina = visina;
	}

	public String getIme() {
		return ime;
	}

	public int getVisina() {
		return visina;
	}

	public String toString() {
		return ime + "(" + visina + ")";
	}

	public static String toString(Planina[] niz) {
		/*
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == null)
				continue;
			if (i != 0)
				s.append(", ");
			s.append(niz[i]);
		}
		return s.toString();
		*/
		
		String str = "";
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == null)
				continue;
			if (i != 0)
				str += ", ";
			str += niz[i];
		}
		return str;
	}

}
