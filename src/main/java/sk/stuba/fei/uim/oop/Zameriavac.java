package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.List;

public class Zameriavac {
    private final List<Boolean> zameriavace = new ArrayList<>();

    public Zameriavac() {
        for (int i = 1; i <= 6; i++) {
            zameriavace.add(Boolean.FALSE);
        }
    }

    public boolean jeZameriavac(int ciel) {
        return zameriavace.get(ciel);
    }

    public void zamierit (int ciel) {
        zameriavace.set(ciel, Boolean.TRUE);
    }

    public void odstranitZameriavac(int ciel) {
        zameriavace.set(ciel, Boolean.FALSE);
    }

    public void vypis() {
        System.out.println(zameriavace);
    }

    public void vystrel(int ciel) {
        if (vsetkyPolickaSuNezamierene()) {
            throw new IllegalArgumentException("Nemozem vystrelit, pretoze nikde nie je zamierene. Vyber dalsiu kartu");
        }
        if (!jeZameriavac(ciel)) {
            throw new IllegalArgumentException("Vystrelit vieme zahrat iba na policko, nad ktorym je zameriavac.");
        }
        odstranitZameriavac(ciel);
    }

    private boolean vsetkyPolickaSuNezamierene() {
        boolean vsetkySuNezamierene = true;
        for (Boolean zameriavac: zameriavace){
            if (zameriavac == Boolean.TRUE) {
                vsetkySuNezamierene = false;
                break;
            }
        }
        return vsetkySuNezamierene;
    }
}
