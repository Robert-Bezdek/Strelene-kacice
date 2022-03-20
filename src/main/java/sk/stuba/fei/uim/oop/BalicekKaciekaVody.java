package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.KartyRybnika.Kacica;
import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;
import sk.stuba.fei.uim.oop.KartyRybnika.Voda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalicekKaciekaVody {

    List<KartaRybnika> kartyRybnika = new ArrayList<>();

    public BalicekKaciekaVody(int pocetHracov, int pocetKarietVoda, int pocetKacicNaHraca) {

        for (int i = 1; i <= pocetKarietVoda; i++) {
            kartyRybnika.add(new Voda());
        }

        for (int cisloHraca = 1; cisloHraca <= pocetHracov; cisloHraca++) {
            for (int cisloKacice = 1; cisloKacice <= pocetKacicNaHraca; cisloKacice++) {
                kartyRybnika.add(new Kacica(cisloHraca));
            }
        }
        zamiesaj();
    };

    public void zamiesaj(){
        Collections.shuffle(kartyRybnika);
    };

    public KartaRybnika lizniKartu(){
        return kartyRybnika.remove(0);
    };

    public void vlozNaKoniec(KartaRybnika k){
        kartyRybnika.add(k);
    };
}
