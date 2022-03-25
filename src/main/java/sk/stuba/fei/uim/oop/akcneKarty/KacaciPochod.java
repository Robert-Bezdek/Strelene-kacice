package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public class KacaciPochod implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik rybnik, BalicekKaciekaVody balicekKaciekaVody, Zameriavac zameriavac) {
        System.out.println("Hrame akcnu kartu KACACI POCHOD");

        balicekKaciekaVody.vlozNaKoniec(
                rybnik.vyberKartuZoZaciatku()
        );
        rybnik.vlozKartuNaKoniec(
                balicekKaciekaVody.lizniKartu()
        );
    }

    @Override
    public String toString(){
        return "Kacaci pochod";
    }
}
