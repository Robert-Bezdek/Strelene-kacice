package sk.stuba.fei.uim.oop.KartyRybnika;

import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;
import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Kacica implements KartaRybnika {
    public Hrac getPatriHracovi() {
        return patriHracovi;
    }

    final Hrac patriHracovi;

    public Kacica(Hrac h){
        patriHracovi = h;
    }

    @Override
    public String toString(){
        return "Kacka hraca " + getPatriHracovi().getCisloHraca();
    }
}
