package sk.stuba.fei.uim.oop;

public class Rosambo implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        System.out.println("Hrame akcnu kartu ROSAMBO");
        r.zamiesaj();
    }
}
