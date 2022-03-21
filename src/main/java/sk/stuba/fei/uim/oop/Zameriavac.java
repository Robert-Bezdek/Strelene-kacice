package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Zameriavac {
    private final boolean[] zameriavace = new boolean[6];

    public boolean jeZameriavac(int ciel) {
        return zameriavace[ciel];
    }

    public void zamierit (int ciel) {
        zameriavace [ciel] = true;
    }

    public void odstranitZameriavac(int ciel) {
        zameriavace [ciel] = false;
    }
}
