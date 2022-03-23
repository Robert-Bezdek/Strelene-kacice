package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.KartyRybnika.Voda;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Turbokacka implements AkcneKarty {
    private boolean jeNeplatna(int poziciaKacky){
        return !(poziciaKacky>=0 && poziciaKacky<=5);
    }

    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        System.out.println("Hrame akcnu kartu TURBOKACKA");

        int poziciaKacky;
        do {
            poziciaKacky = KeyboardInput.readInt("Vlozte poziciu kacky od 0 do 5 a stlacte ENTER");
        } while (jeNeplatna(poziciaKacky) || r.pozriKartu(poziciaKacky) instanceof Voda);

        System.out.println("Turbokacka je " + r.pozriKartu(poziciaKacky));

        r.vlozKartuNaZaciatok(
                r.vyberKartu(poziciaKacky)
        );
    }

    @Override
    public String toString(){
        return "Turbokacka";
    }
}
