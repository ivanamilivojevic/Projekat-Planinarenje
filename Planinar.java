package planinarenje;

import java.util.Date;

public abstract class Planinar {
	private String ime;
	private static int ukID = 0;
	private int id = ++ukID;
	private PlaninaZaZbirku[] zbirka;
	private int pop;
	
	private int poeni = 0;
	
	

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		this.poeni = poeni;
	}

	public Planinar(String ime, int kap) {
		this.ime = ime;
		zbirka = new PlaninaZaZbirku[kap];
		
	}
	
	public PlaninaZaZbirku[] getZbirka() {
		return zbirka;
	}

	public void dodaj(Planina p) {
		if (pop < zbirka.length) {
			zbirka[pop] = new PlaninaZaZbirku(p,new Date());
			pop++;
		}
	}
	
	// ako zelimom da zadamo i datum penjanja koji nije 'danasnji'
	public void dodaj(Planina p, Date d) {
		if (pop < zbirka.length) {
			zbirka[pop] = new PlaninaZaZbirku(p,d);
			pop++;
		}
	}
	
	protected abstract boolean penjiSe(Planina p);

	public boolean popniSe(Planina p) {
		if (penjiSe(p)) {
			dodaj(p);
			return true;
		}
		return false;
	}
	
	public boolean popniSe(Planina p, Date d) {
		if (penjiSe(p)) {
			dodaj(p, d);
			return true;
		}
		return false;
	}

	public String toString() {
		Planina[] niz = new Planina[pop];
		for (int i=0; i<pop; i++) {
			niz[i]= zbirka[i].getPlanina();
		}
		return ime + "-" + id + "(" + Planina.toString(niz) + ")";
	}

}
