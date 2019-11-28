package kolekcjaAlarmow;

import dto.ObjectDTOInterface;
import podstawa.Runner;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionOfObjects<T extends ObjectDTOInterface> {
    private CopyOnWriteArrayList<T> collection=new CopyOnWriteArrayList<>();

    public void setCollectionA(List<T> collection) {
        this.collection.addAll(collection);
    }

    public synchronized void add(T alarm){
        this.collection.add(alarm);
        Runner.getWindow().setParametersA(this.collection);
    }

    public synchronized void remove(int i){
        this.collection.remove(i);
        Runner.getWindow().setParametersA(this.collection);
    }

    public synchronized void add (T alarm, int i){
        this.collection.add(i,alarm);
        Runner.getWindow().setParametersA(this.collection);

    }

    public List<T> getCollection(){
        return this.collection;
    }
    public T getAlarm(int i){
        return this.collection.get(i);
    }
}
