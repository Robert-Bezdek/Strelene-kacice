package sk.stuba.fei.uim.oop;

import java.util.LinkedList;
import java.util.List;

public class BalicekAkcnychKariet {
    LinkedList<AkcneKarty> akcneKarty = new LinkedList<>();

    public void pridaj(AkcneKarty akcnaKarta){
        this.akcneKarty.add(akcnaKarta);
    }

    public AkcneKarty lizni(){
        return this.akcneKarty.removeFirst();
    }
}
