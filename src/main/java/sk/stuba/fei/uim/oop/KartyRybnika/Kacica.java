package sk.stuba.fei.uim.oop.KartyRybnika;

import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;

public class Kacica implements KartaRybnika {
    public int getPatriHracovi() {
        return patriHracovi;
    }

    public String toString(){
        return "Kacka hraca cislo " + getPatriHracovi();
    }

    final int patriHracovi;

    public Kacica(int patriHracovi){
        this.patriHracovi = patriHracovi;
    };
}
