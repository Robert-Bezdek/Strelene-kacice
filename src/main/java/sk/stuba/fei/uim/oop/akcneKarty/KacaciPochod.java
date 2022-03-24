package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public class KacaciPochod implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        b.vlozNaKoniec(r.vyberKartuZoZaciatkuRybnika());
        r.vlozKartuNakoniecRybnika(b.lizniKartu());
    }
    public String toString(){
        return "Kacaci pochod";
    }
}
