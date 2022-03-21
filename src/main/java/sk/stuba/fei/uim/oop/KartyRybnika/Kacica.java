package sk.stuba.fei.uim.oop.KartyRybnika;

import sk.stuba.fei.uim.oop.KartyRybnika.KartaRybnika;

public class Kacica implements KartaRybnika {
    public int getPatriHracovi() {
        return patriHracovi;
    }

    final int patriHracovi;

    public Kacica(int patriHracovi){
        this.patriHracovi = patriHracovi;
    }

    @Override
    public String toString(){
        return "Kacka hraca " + getPatriHracovi();
    }
}
