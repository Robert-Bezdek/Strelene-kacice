package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rybnik {

    List<KartaRybnika> kartyRybnika = new ArrayList<>();

    public KartaRybnika vyberKartuZoZaciatkuRybnika(){

        return this.kartyRybnika.remove(0);
    }

    public void vlozKartuNakoniecRybnika(KartaRybnika k) {
        this.kartyRybnika.add(k);
    }

    public KartaRybnika pozriKartu(int pozicia){

        return kartyRybnika.get(pozicia);
    }

    public KartaRybnika vyberKartu(int pozicia) {

        return kartyRybnika.remove(pozicia);
    }

    public void vlozKartuNaZaciatok(KartaRybnika vyberKartu) {
        kartyRybnika.add(0,vyberKartu);
    }

    public void zamiesaj(){
        Collections.shuffle(kartyRybnika);
    }
}


