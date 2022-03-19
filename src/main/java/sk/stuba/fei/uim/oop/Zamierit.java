package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Zamierit implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        int ciel = KeyboardInput.readInt("Vyber policko, na ktore mieris: [1-6]", 3);
        ciel--;
        if (z.jeZameriavac(ciel)) {
            return;
        }
        z.zamierit(ciel);
    }
}
