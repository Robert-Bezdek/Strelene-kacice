package sk.stuba.fei.uim.oop.akcneKarty;

import sk.stuba.fei.uim.oop.BalicekKaciekaVody;
import sk.stuba.fei.uim.oop.KartyRybnika.Kacica;
import sk.stuba.fei.uim.oop.Rybnik;
import sk.stuba.fei.uim.oop.Zameriavac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class DivokyBill implements AkcneKarty {
    @Override
    public void pouzitKartu(Rybnik r, BalicekKaciekaVody b, Zameriavac z) {
        int ciel;
        do {
            ciel = KeyboardInput.readInt("Vyber policko, na ktore mieris a strielas: [0-5]");
            try {
                z.zamierit(ciel);
                z.vystrel(ciel);
                if (r.pozriKartu(ciel) instanceof Kacica){
                    ((Kacica) r.vyberKartu(ciel)).getPatriHracovi().zasiahni();
                    r.vlozKartuNaKoniec(b.lizniKartu());
                }

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
        return "Divoky Bill";
    }
}
