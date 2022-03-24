package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public class KacaciTanec implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        System.out.println("Pouzil si kartu kacaci tanec");
        for (int i = 1; i <= 6; i++) {
            b.vlozNaKoniec(r.vyberKartuZoZaciatkuRybnika());
        }
        b.zamiesaj();
        for (int i = 1; i <= 6; i++) {
            r.vlozKartuNakoniecRybnika(b.lizniKartu());
        }
    }

    public String toString(){
        return "Kacaci tanec";
    }
}
