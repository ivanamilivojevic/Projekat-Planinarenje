package planinarenje;

import java.util.Date;
import java.util.LinkedList;

public class PlaninarskoDrustvo {
	private String naziv;
	private int godina;
	private LinkedList<Planinar> clanovi;

	public PlaninarskoDrustvo(String naziv, int godina, Planinar[] osnivaci) {
		this.naziv = naziv;
		this.godina = godina;
		clanovi= new LinkedList<Planinar>();
		for (int i = 0; i < osnivaci.length; i++)
			clanovi.add(osnivaci[i]);
		
	}

	public PlaninarskoDrustvo uclani(Planinar p) {
		clanovi.add(p);
		return this;
	}

	public Planinar dohvatiPlaninara(int i) {
		return clanovi.get(i);
	}

	public int brojPlaninara() {
		return clanovi.size();
	}

	public void rangiranje() {
		for (int i = 0; i < clanovi.size(); i++) {
			Planinar tekuci = clanovi.get(i);
			PlaninaZaZbirku[] zbirka = tekuci.getZbirka();
			Date danas = new Date();
			
			long mesecDana = 1;
	        mesecDana= mesecDana* 30*24*60*60*1000;
			//long mesecDana= 30*24*60*60*1000;
			int suma = 0;
			for (int j = 0; j < zbirka.length; j++) {
				
				//if (zbirka[j] != null && danas.getTime() - zbirka[j].getDatum().getTime() < mesecDana) {
					if (zbirka[j] != null && danas.getTime() - zbirka[j].getDatum().getTime() < mesecDana) {
					
						suma += zbirka[j].getPlanina().getVisina();
						if (zbirka[j].getPlanina().getVisina() > 1800)
							suma += 300;
				}

			}
			tekuci.setPoeni(suma);
		}

		for (int i = 0; i < clanovi.size() - 1; i++) {
			Planinar naj_p = clanovi.get(i);
			int poz = i;
			for (int j = i + 1; j < clanovi.size(); j++) {
				if (clanovi.get(j).getPoeni() > naj_p.getPoeni()) {
					poz = j;
					naj_p = clanovi.get(j);
				}
			}
			/*
			clanovi.remove(poz);
			clanovi.add(poz, clanovi.get(i));
			clanovi.remove(i);
			clanovi.add(i, naj_p);
			*/
			clanovi.set(poz, clanovi.get(i));
			clanovi.set(i, naj_p);
		}
		/*
		for (int i = 0; i < clanovi.size(); i++) {
			System.out.println(clanovi.get(i));
		}
		*/
		
		for (Planinar p: clanovi) {
			System.out.println(p);
		}
	}

	public String toString() { // jos bolje iteratorom
		String s =" ";
		for (int i = 0; i < clanovi.size(); i++) {
			s += (clanovi.get(i) + "\n");
		}
		return s;
	}
}
