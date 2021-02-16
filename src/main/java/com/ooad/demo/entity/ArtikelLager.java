package com.ooad.demo.entity;

import java.util.ArrayList;

public class ArtikelLager {
	private ArrayList<Artikel> artikelListe;
	
	//Das Lager wird zur Laufzeit mit Beispiel-Artikel befüllt 
	public ArtikelLager(){
		this.artikelListe = new ArrayList<Artikel>();
		Artikel artikel1 = new Artikel("Nike Schuhe", "Schuhgröße: 43", 59.99, "https://img01.ztat.net/article/spp-media-p1/0034959e2d1a3105aa6c338b9cea6ffd/28bcaf048f714eb8b66d715a43848c6b.jpg?imwidth=762&filter=packshot");
		Artikel artikel2 = new Artikel("T-Shirt", "Größe: M", 19.99, "https://www.engelhorn.de/dw/image/v2/AALR_PRD/on/demandware.static/-/Sites-engelhorn-master-plattform/default/dwa4f41b57/images/P10/04/06/7B/V1070643M/engelhorn-Nike-Sportswear-Herren-T-Shirt-Club-Vorderansicht-V1070643M-v1.jpg?sw=365&sh=438&sm=fit");	
		Artikel artikel3 = new Artikel("Hose", "Größe: 30/30", 29.99, "https://www.engelhorn.de/dw/image/v2/AALR_PRD/on/demandware.static/-/Sites-engelhorn-master-plattform/default/dwceec5004/images/P10/04/06/6K/V1005619W/engelhorn-Nike-Sportswear-Herren-Sweathose-Club-Vorderansicht-V1005619W-v1.jpg?sw=365&sh=438&sm=fit");
		this.artikelListe.add(artikel1);
		this.artikelListe.add(artikel2);
		this.artikelListe.add(artikel3);
	}
	
	public void neuenArtikelHinzufuegen(Artikel neuerArtikel) {
		if(neuerArtikel != null) {
			this.artikelListe.add(neuerArtikel);
		} else {
			System.out.println("Artikel ist null!");
		}
	}

	public ArrayList<Artikel> getArtikelListe() {
		return this.artikelListe;
	}
}
