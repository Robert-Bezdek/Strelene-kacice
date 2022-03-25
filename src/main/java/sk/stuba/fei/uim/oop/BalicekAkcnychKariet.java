package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.akcneKarty.AkcneKarty;

import java.util.Collections;
import java.util.LinkedList;

public class BalicekAkcnychKariet {
    LinkedList<AkcneKarty> akcneKarty = new LinkedList<>();

    public void pridaj(AkcneKarty akcnaKarta){
        this.akcneKarty.add(akcnaKarta);
    }

    public AkcneKarty lizni(){
        if (akcneKarty.isEmpty()){
            throw new RuntimeException("Balicek akcnych kariet je prazdny");
        }
        return this.akcneKarty.removeFirst();
    }

    public void zamiesaj(){
        Collections.shuffle(akcneKarty);
    }
}
