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

            if (neplatnyPocetHracov(pocetHracov)){
                System.out.println("Zadali ste neplatny pocet hracov, platne hodnoty su 2,3,4,5,6.");
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

        for (int i=1; i<=10; i++){
            bak.pridaj(new Zamierit());
        }

        for (int i=1; i<=12; i++){
            bak.pridaj(new Vystrelit());
        }

        bak.zamiesaj();

        List<Hrac> hraci = new LinkedList<>();
        for (int cisloHraca = 1; cisloHraca <= pocetHracov; cisloHraca++){
            Hrac hrac = new Hrac(cisloHraca);

            hrac.dajKartuHracovi(bak.lizni());
            hrac.dajKartuHracovi(bak.lizni());
            hrac.dajKartuHracovi(bak.lizni());

            hraci.add(hrac);
        }

        BalicekKaciekaVody b = new BalicekKaciekaVody(pocetHracov, 5, hraci);
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());
        r.vlozKartuNaKoniec(b.lizniKartu());

        while (hraci.size() > 1){
            System.out.println("\nZacina nove kolo");
            System.out.println("Zostalo " + hraci.size() + " hracov\n");

            for (Hrac hrac : hraci) {
                try {
                    AkcneKarty karta = hrac.vyberKartu(z);

                    vypisHraciePole(r, z);
                    karta.pouzitKartu(r, b, z);
                    vypisHraciePole(r, z);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Kedze hrac nemoze zahrat ziadnu kartu, zahadzuje jednu z kariet");
                    hrac.zahodJednuKartu();
                }

                try {
                    System.out.println("Hrac vybera novu kartu z balika");
                    hrac.dajKartuHracovi(bak.lizni());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
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

    private void vypisPoctyZivotov(final List<Hrac> hraci){
        for (Hrac h: hraci){
            System.out.println("Hrac " + h.getCisloHraca() + " ma "+ h.getPocetZivotov() + " zivotov");
        }
    }

    void vypisHraciePole(Rybnik rybnik, Zameriavac zameriavac){
        System.out.println("Vypisujem hracie pole:");

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

        System.out.println();
    }

    private void testAkcnychKariet(Rybnik r, Zameriavac z){
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

        Vystrelit kartaVystrelit = new Vystrelit();
        vypisHraciePole(r,z);
        //kartaVystrelit.pouzitKartu(r,b,z);
        vypisHraciePole(r,z);
    }

    private void testZameriavaca(Zameriavac z){
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
    }
}
