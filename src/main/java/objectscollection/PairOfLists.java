package objectscollection;

import dtoobjects.ObjectDTOInterface;

import java.util.concurrent.CopyOnWriteArrayList;

public class PairOfLists<CollectionOfObjects> {
    private CollectionOfObjects A;
    private CollectionOfObjects B;


    public PairOfLists(CollectionOfObjects A, CollectionOfObjects B){
    this.A=A;
    this.B=B;
    }

    public CollectionOfObjects getA(){
        return A;
    }

    public CollectionOfObjects getB(){
        return B;
    }
}
