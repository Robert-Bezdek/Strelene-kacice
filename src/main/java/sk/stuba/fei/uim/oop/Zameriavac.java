package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.KartyRybnika.Voda;

import java.util.List;
import java.util.ArrayList;

public class Zameriavac {
    private final List<Boolean> zameriavace = new ArrayList<>();

    public Zameriavac(){
        for (int i=1; i<=6; i++){
            zameriavace.add(Boolean.FALSE);
        }
    }

    public boolean jeZameriavac(int ciel) {
        return zameriavace.get(ciel);
    }

    public void zamierit (int ciel) {
        if (jeZameriavac(ciel)) {
            throw new IllegalArgumentException("Zamierit vieme zahrat iba na policko, nad ktorym este zameriavac nie je.");
        }

        zameriavace.set(ciel, Boolean.TRUE);
    }

    public void odstranitZameriavac(int ciel) {
        zameriavace.set(ciel, Boolean.FALSE);
    }

    public void vypis(){
        System.out.println(zameriavace);
    }

    public void vystrel(int ciel){
        if (!jeZameriavac(ciel)) {
            throw new IllegalArgumentException("Vystrelit vieme iba na policko, nad ktorym je zameriavac.");
        }
        odstranitZameriavac(ciel);
    }

    public boolean ziadnaKartaNieJeZamierena(){
        for (Boolean zameriavac: zameriavace){
            if (zameriavac.booleanValue() == Boolean.TRUE){
                return false;
            }
        }

        return true;
    }

    public boolean vsetkyKartySuZamierene() {
        for (Boolean zameriavac: zameriavace){
            if (zameriavac.booleanValue() == Boolean.FALSE){
                return false;
            }
        }

        return true;
    }
}
