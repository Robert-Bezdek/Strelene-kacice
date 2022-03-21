package sk.stuba.fei.uim.oop.streleneKacice;

import sk.stuba.fei.uim.oop.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.LinkedList;
import java.util.List;

public class StreleneKacice {

    private List<Hrac> hraci = new LinkedList<Hrac>();

    private boolean neplatnyPocetHracov(int pocetHracov){
        return !(pocetHracov>=2 && pocetHracov<=6);
    }

    public StreleneKacice() {

        System.out.println("Vytajte v hre FEI Strelene kacice");

        int pocetHracov;
        do {
            pocetHracov = KeyboardInput.readInt("Vlozte pocet hracov od 2 do 6 a stlacte ENTER");
        } while (neplatnyPocetHracov(pocetHracov));

        System.out.println("Zadali ste " + pocetHracov);

        for (int cisloHraca = 1; cisloHraca <= pocetHracov; cisloHraca++){
            Hrac hrac = new Hrac(cisloHraca);

            // TODO: rozdaj 3 akcne karty hracovi (az ked naprogramujeme BalicekAkcnychKariet)
            //hrac.dajKartuHracovi(balicekAkcnychKariet.lizni());
            //hrac.dajKartuHracovi(balicekAkcnychKariet.lizni());
            //hrac.dajKartuHracovi(balicekAkcnychKariet.lizni());

            hraci.add(hrac);
        }

        BalicekKaciekaVody b = new BalicekKaciekaVody(pocetHracov, 5, 5);
        Rybnik r = new Rybnik();
        Zameriavac z = new Zameriavac();

        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
    }
}
