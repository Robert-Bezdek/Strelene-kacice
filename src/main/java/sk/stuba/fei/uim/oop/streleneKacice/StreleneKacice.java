package sk.stuba.fei.uim.oop.streleneKacice;

import sk.stuba.fei.uim.oop.*;
import sk.stuba.fei.uim.oop.akcneKarty.KacaciPochod;
import sk.stuba.fei.uim.oop.akcneKarty.KacaciTanec;
import sk.stuba.fei.uim.oop.akcneKarty.Rosambo;
import sk.stuba.fei.uim.oop.akcneKarty.Turbokacka;
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

        BalicekKaciekaVody b = new BalicekKaciekaVody(pocetHracov, 5, 5);
        Rybnik r = new Rybnik();
        Zameriavac z = new Zameriavac();

        List<Hrac> hraci = new LinkedList<>();

        for(int cisloHraca = 1; cisloHraca <= pocetHracov; cisloHraca++) {
            Hrac hrac = new Hrac(cisloHraca);
            hraci.add(hrac);
        }

        for (int i = 1; i <= 6; i++) {
            r.vlozKartuNakoniecRybnika(b.lizniKartu());
        }
        vypisHraciePole(r, z);
        Turbokacka tk = new Turbokacka();
        System.out.println("\nVypisujem obsah rybnika pred pouzitim karty TURBOKACKA:\n");
        vypisHraciePole(r,z);
        tk.pouzitKartu(r,b,z);
        vypisHraciePole(r,z);

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
    }

    private boolean neplatnyPocetHracov(int pocetHracov){
        return !(pocetHracov>=2 && pocetHracov<=6);
    }

    public void vypisHraciePole(Rybnik rybnik, Zameriavac zameriavac){
        for (int i = 0; i<=5; i++){
            System.out.print(zameriavac.jeZameriavac(i) ? "Zamierene" : "Nezamierene");
            System.out.print(" - ");
            System.out.println(rybnik.pozriKartu(i).toString());
        }
    }
}
