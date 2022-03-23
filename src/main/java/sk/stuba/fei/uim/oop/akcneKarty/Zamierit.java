package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Zamierit implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        int ciel;
        do {
            ciel = KeyboardInput.readInt("Vyber policko, na ktore mieris: [0-5]");
            try {
                z.zamierit(ciel);
                break;
            } catch (IndexOutOfBoundsException e){
                System.out.println("Neplatna pozicia zameriavaca, platne pozicie su 0,1,2,3,4,5.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    @Override
    public String toString(){
        return "Zamierit";
    }
}
