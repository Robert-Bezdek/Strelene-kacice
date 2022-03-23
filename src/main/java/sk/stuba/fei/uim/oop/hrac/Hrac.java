package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;

import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private int cisloHraca;
    private int pocetZivotov;
    private List<AkcneKarty> kartyHraca = new ArrayList<>();

    public int getCisloHraca(){

        return cisloHraca;
    };

    public void dajKartuHracovi(AkcneKarty karta){

        kartyHraca.add(karta);
    };

    public Hrac(int cisloHraca) {
        this.cisloHraca = cisloHraca;
    }
}
