package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private final int cisloHraca;
    private int pocetZivotov = 5;

    public int getPocetZivotov() {
        return pocetZivotov;
    }

    public void zasiahni(){
        System.out.println("Zasiahli sme hraca " + getCisloHraca());
        --pocetZivotov;
        System.out.println("Zostalo mu " + getPocetZivotov() + " zivotov\n");
    }

    public AkcneKarty vyberKartu(){
        System.out.print("Karty hraca " + cisloHraca + ": ");
        vypisKarty();

        int pozicia;
        do {
            pozicia = KeyboardInput.readInt("Hrac " + getCisloHraca() + ": Vlozte poziciu karty od 0 do 2 a stlacte ENTER");

            try {
                return kartyHraca.remove(pozicia);
            } catch (IndexOutOfBoundsException e){
                System.out.println("Neplatna pozicia karty, platne pozicie su 0,1,2.");
            }
        } while (true);
    }

    public void vypisKarty(){
        System.out.println();

        int i = 0;
        for (AkcneKarty karta: kartyHraca){
            System.out.println(i + ". " + karta);
            i++;
        }

        System.out.println();
    }

    private final List<AkcneKarty> kartyHraca = new ArrayList<>();

    public int getCisloHraca(){

        return cisloHraca;
    }

    public void dajKartuHracovi(AkcneKarty karta){

        kartyHraca.add(karta);
    }

    public Hrac(int cisloHraca){
        this.cisloHraca = cisloHraca;
    }
}
