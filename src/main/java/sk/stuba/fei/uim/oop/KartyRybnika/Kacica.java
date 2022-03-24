package sk.stuba.fei.uim.oop.KartyRybnika;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Kacica implements KartaRybnika {
    public Hrac getPatriHracovi() {
        return patriHracovi;
    }

    public String toString(){
        return "Kacka hraca cislo " + getPatriHracovi().getCisloHraca();
    }

    final Hrac patriHracovi;

    public Kacica(Hrac patriHracovi){
        this.patriHracovi = patriHracovi;
    };
}
