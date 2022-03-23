package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;

public class DivokyBill implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        Zamierit zamierit = new Zamierit();
        Vystrelit vystrelit = new Vystrelit();

        zamierit.pouzitKartu(r,b,z);
        vystrelit.pouzitKartu(r,b,z);
    }

    @Override
    public String toString(){
        return "Divoky Bill";
    }
}
