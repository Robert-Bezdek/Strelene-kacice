package sk.stuba.fei.uim.oop.streleneKacice;

import sk.stuba.fei.uim.oop.*;
import sk.stuba.fei.uim.oop.akcneKarty.*;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.LinkedList;
import java.util.List;

public class StreleneKacice {

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

        List<Hrac> hraci = new LinkedList<>();
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

        KacaciPochod kacaciPochod = new KacaciPochod();
        //System.out.println("Vypisujem obsah rybnika pred pouzitim karty KACACI POCHOD:");
        vypisHraciePole(r,z);
        //kacaciPochod.pouzitKartu(r, b, z);
        vypisHraciePole(r,z);

        Turbokacka tk = new Turbokacka();
        //System.out.println("Vypisujem obsah rybnika pred pouzitim karty TURBOKACKA:");
        vypisHraciePole(r,z);
        //tk.pouzitKartu(r,b,z);
        vypisHraciePole(r,z);

        KacaciTanec kt = new KacaciTanec();
        //System.out.println("Vypisujem obsah rybnika pred pouzitim karty KACACI TANEC:");
        vypisHraciePole(r,z);
        //kt.pouzitKartu(r,b,z);
        vypisHraciePole(r,z);

        Rosambo rosambo = new Rosambo();
        //System.out.println("Vypisujem obsah rybnika pred pouzitim karty ROSAMBO:");
        vypisHraciePole(r,z);
        //rosambo.pouzitKartu(r,b,z);
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

        z.vypis();
        z.zamierit(0);
        z.vypis();
        z.odstranitZameriavac(0);
        z.vypis();

        try {
            z.zamierit(12345);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Neplatna pozicia zameriavaca, platne pozicie su 0,1,2,3,4,5.");
        }

        try {
            z.zamierit(5);
            z.zamierit(5);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Zamierit kartaZamierit = new Zamierit();
        z.vypis();
        //kartaZamierit.pouzitKartu(r,b,z);
        z.vypis();
        //kartaZamierit.pouzitKartu(r,b,z);
        z.vypis();
        //kartaZamierit.pouzitKartu(r,b,z);
        z.vypis();

        Vystrelit kartaVystrelit = new Vystrelit();
        vypisHraciePole(r,z);
        kartaVystrelit.pouzitKartu(r,b,z);
        vypisHraciePole(r,z);
    }

    void vypisHraciePole(Rybnik rybnik, Zameriavac zameriavac){
        for (int i = 0; i<=5; i++){
            System.out.print(i + ". ");
            System.out.print(
                    zameriavac.jeZameriavac(i) ? "Zamierene" : "Nezamierene"
            );
            System.out.print(" - ");
            System.out.println(
                    rybnik.pozriKartu(i).toString()
            );
        }
    }
}
