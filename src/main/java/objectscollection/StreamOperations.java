package objectscollection;

import dtoobjects.AlarmDTO;

import java.util.concurrent.CopyOnWriteArrayList;

public class StreamOperations {
public <T> PairOfLists divideIntoTwoLists(CopyOnWriteArrayList<T> copyOnWriteArrayList){
    CopyOnWriteArrayList<T> A=new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<T> B=new CopyOnWriteArrayList<>();
    int length = copyOnWriteArrayList.size();
    for(int i=0; i<=length/2;i++){
        A.add(copyOnWriteArrayList.get(i));
    }
    for(int i=length/2; i<=length;i++){
        B.add(copyOnWriteArrayList.get(i));
    }
    PairOfLists pairOfLists = new PairOfLists(A,B);
    return pairOfLists;

    
}
}
