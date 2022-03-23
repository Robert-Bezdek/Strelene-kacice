package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public interface AkcneKarty {

    void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z);
    String toString(); // vypise typ karty
}
