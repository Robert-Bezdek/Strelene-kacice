package sk.stuba.fei.uim.oop;

public class KacaciPochod implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik rybnik, BalicekKaciekaVody balicekKaciekaVody, Zameriavac zameriavac) {
        balicekKaciekaVody.vlozNaKoniec(
                rybnik.vyberKartuZoZaciatku()
        );
        rybnik.vlozKartuNaKoniec(
                balicekKaciekaVody.lizniKartu()
        );
    }
}
