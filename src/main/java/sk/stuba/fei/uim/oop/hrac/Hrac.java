package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

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

    public void zasiahni() {
        System.out.println("Zasiahli sme kacicu hraca cislo " + getCisloHraca());
        pocetZivotov--;
        System.out.println("Trafenemu hracovi ostalo" + pocetZivotov + "pocet zivotov");
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
        for (int i=0; i<=2; i++){
            System.out.println(i + ". " + kartyHraca.get(i));
        }
    }

    public int getPocetZivotov() {
        return pocetZivotov;
    }

}
