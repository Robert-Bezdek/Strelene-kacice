package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public class KacaciTanec implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        System.out.println("Hrame akcnu kartu KACACI TANEC");

        for (int i=0; i<=5; i++){
            b.vlozNaKoniec(r.vyberKartuZoZaciatku());
        }

        b.zamiesaj();

        for (int i=0; i<=5; i++){
            r.vlozKartuNaKoniec(b.lizniKartu());
        }
    }

    @Override
    public String toString(){
        return "Kacaci tanec";
    }
}
