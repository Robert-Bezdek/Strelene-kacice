package sk.stuba.fei.uim.oop.streleneKacice;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class StreleneKacice {
    public StreleneKacice() {

        System.out.println("Vytajte v hre FEI Strelene kacice");
        int pocetHracov = 0;
        while (pocetHracov < 2 || pocetHracov > 6) {
            pocetHracov = KeyboardInput.readInt("Vlozte pocet hracov od 2 do 6 a stlacte ENTER");
            if (pocetHracov <2 || pocetHracov > 6) {
                System.out.println("Pocet hracov musi byt od 2 do 6.");
            }
        }
        System.out.println("Zadali ste " + pocetHracov);

        BalicekKaciekaVody b = new BalicekKaciekaVody(pocetHracov, 5, 5);
        Rybnik r = new Rybnik();
    };
}
