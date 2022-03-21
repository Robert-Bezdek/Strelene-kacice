package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.KartyRybnika.Kacica;
import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rybnik {

    List<KartaRybnika> kartyRybnika = new ArrayList<>();


    public KartaRybnika vyberKartu(int pozicia){
        return kartyRybnika.remove(pozicia);
    }

    public KartaRybnika pozriKartu(int pozicia){
        return kartyRybnika.get(pozicia);
    }

    public KartaRybnika vyberKartuZoZaciatku(){
        return vyberKartu(0);
    }

    public void vlozKartuNaKoniec(KartaRybnika k){
        kartyRybnika.add(k);
    }

    public void vlozKartuNaZaciatok(KartaRybnika k) {kartyRybnika.add(0,k);}
}
