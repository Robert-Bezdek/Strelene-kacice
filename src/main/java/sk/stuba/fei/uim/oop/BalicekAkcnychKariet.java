package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;

import java.util.Collections;
import java.util.LinkedList;

public class BalicekAkcnychKariet {
    LinkedList<AkcneKarty> akcnekarty = new LinkedList<>();

    public void pridaj(AkcneKarty akcnaKarta) {
        akcnekarty.add(akcnaKarta);
    }

    public AkcneKarty lizni(){
        return akcnekarty.removeFirst();
    }

    public void zamiesaj(){
        Collections.shuffle(akcnekarty);
    }
}

