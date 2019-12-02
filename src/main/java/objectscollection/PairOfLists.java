package objectscollection;

import java.util.concurrent.CopyOnWriteArrayList;

public class PairOfLists<CopyOnWriteArrayList> {
    private CopyOnWriteArrayList A;
    private CopyOnWriteArrayList B;


    public PairOfLists(CopyOnWriteArrayList A, CopyOnWriteArrayList B){
    this.A=A;
    this.B=B;
    }

    public CopyOnWriteArrayList getA(){
        return A;
    }

    public CopyOnWriteArrayList getB(){
        return B;
    }
}
