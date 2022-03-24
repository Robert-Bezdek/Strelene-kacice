package sk.stuba.fei.uim.oop.streleneKacice;

import sk.stuba.fei.uim.oop.*;
import sk.stuba.fei.uim.oop.akcneKarty.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;
import java.util.LinkedList;
import java.util.List;

public class StreleneKacice {
    public StreleneKacice() {

        System.out.println("Vytajte v hre FEI Strelene kacice\n");
        int pocetHracov;
        do {
            pocetHracov = KeyboardInput.readInt("Vlozte pocet hracov od 2 do 6 a stlacte ENTER");
            if (neplatnyPocetHracov(pocetHracov)) {
                System.out.println("\nZadal si zly vstup, zadaj znova pocet hracov: \n");
            }
        } while (neplatnyPocetHracov(pocetHracov));
        System.out.println("Zadali ste " + pocetHracov);

        Rybnik r = new Rybnik();
        Zameriavac z = new Zameriavac();

        BalicekAkcnychKariet bak = new BalicekAkcnychKariet();
        bak.pridaj(new KacaciTanec());
        bak.pridaj(new Turbokacka());
        bak.pridaj(new Rosambo());
        bak.pridaj(new Rosambo());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new KacaciPochod());
        bak.pridaj(new DivokyBill());
        bak.pridaj(new DivokyBill());

        for (int i = 1; i <= 10; i++) {
            bak.pridaj(new Zamierit());
        }

        for (int i = 1; i <= 12; i++) {
            bak.pridaj(new Vystrelit());
        }

        bak.zamiesaj();

        List<Hrac> hraci = new LinkedList<>();

        for(int cisloHraca = 1; cisloHraca <= pocetHracov; cisloHraca++) {
            Hrac hrac = new Hrac(cisloHraca);
            hrac.dajKartuHracovi(bak.lizni());
            hrac.dajKartuHracovi(bak.lizni());
            hrac.dajKartuHracovi(bak.lizni());
            hraci.add(hrac);
        }
        BalicekKaciekaVody b = new BalicekKaciekaVody(pocetHracov, 5, hraci);

        for (int i = 1; i <= 6; i++) {
            r.vlozKartuNakoniecRybnika(b.lizniKartu());
        }

        while (hraci.size() > 1) {
            System.out.println("Zacina nove kolo");
            System.out.println("Zostalo nam " + hraci.size() + " hracov");

            for (Hrac hrac : hraci) {
                AkcneKarty karta = hrac.vyberKartu();
                vypisHraciePole(r, z);
                karta.pouzitKartu(r, b, z);
                vypisHraciePole(r, z);
                hrac.dajKartuHracovi(bak.lizni());
            }
            odstranMrtvychHracov(hraci);
            vypisPoctyZivotov(hraci);
            System.out.println("\nKoniec kola. Stlacte ENTER pre nove kolo.");
            KeyboardInput.readChar();
        }
        System.out.println("Vitazom je hrac cislo " + hraci.get(0).getCisloHraca());
    }

    private void odstranMrtvychHracov(List<Hrac> hraci){
        hraci.removeIf(hrac -> hrac.getPocetZivotov() <= 0);
    }

    private boolean neplatnyPocetHracov(int pocetHracov){
        return !(pocetHracov>=2 && pocetHracov<=6);
    }

    private void vypisPoctyZivotov(final List<Hrac> hraci){
        for (Hrac h: hraci){
            System.out.println("Hrac " + h.getCisloHraca() + " ma "+ h.getPocetZivotov() + " zivotov");
        }
    }

    public void vypisHraciePole(Rybnik rybnik, Zameriavac zameriavac) {
        System.out.println();
        for (int i = 0; i <= 5; i++) {
            System.out.print(zameriavac.jeZameriavac(i) ? "Zamierene" : "Nezamierene");
            System.out.print(" - ");
            System.out.println(rybnik.pozriKartu(i).toString());
        }
        System.out.println();
    }
}
