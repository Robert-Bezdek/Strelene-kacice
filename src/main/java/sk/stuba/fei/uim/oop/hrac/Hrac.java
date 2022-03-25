package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.Zameriavac;
import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;
import sk.stuba.fei.uim.oop.akcneKarty.Vystrelit;
import sk.stuba.fei.uim.oop.akcneKarty.Zamierit;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    public void zahodJednuKartu(){
        System.out.println("Zahadzujem kartu hracovi");
        kartyHraca.remove(0);
    }

    public AkcneKarty vyberKartu(Zameriavac zameriavac){
        System.out.print("Karty hraca " + cisloHraca + ": ");
        vypisKartyKtoreMozeZahrat(zameriavac);

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

    public void vypisKartyKtoreMozeZahrat(Zameriavac zameriavac){
        System.out.println();

        boolean mozeZahratAsponJednuKartu = false;
        int i = 0;
        for (AkcneKarty karta: kartyHraca){
            if (karta instanceof Zamierit && zameriavac.vsetkyKartySuZamierene()){
                i++;
                continue;
            }

            if (karta instanceof Vystrelit && zameriavac.ziadnaKartaNieJeZamierena()){
                i++;
                continue;
            }

            System.out.println(i + ". " + karta);
            mozeZahratAsponJednuKartu = true;
            i++;
        }

        if (!mozeZahratAsponJednuKartu){
            throw new RuntimeException("Hrac nemoze zahrat ziadnu kartu");
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
