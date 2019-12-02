// To jest bez użycia concurrent list - występuje słowo synchronized, żeby jednocześnie wątki nie próbowały nadpisać pliku



package useless;

import dtoobjects.AlarmDTO;
import basic.Runner;

import java.util.ArrayList;
import java.util.List;

public class CollectionOfAlarms implements InterfaceCollection {
    private List<AlarmDTO> collection= new ArrayList<>();


    public void setCollection(List<AlarmDTO> collection) {
        this.collection.addAll(collection);
    }

    @Override
    public boolean isEmpty() {
        if (collection.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    public synchronized void add(AlarmDTO alarm){
        this.collection.add(alarm);
        Runner.getWindow().setParameters(this.collection);
    }

    public synchronized void remove(int i){
        this.collection.remove(i);
        Runner.getWindow().setParameters(this.collection);
    }

    public synchronized void add (AlarmDTO alarm, int i){
        this.collection.add(i,alarm);
        Runner.getWindow().setParameters(this.collection);

    }

    public List<AlarmDTO> getCollection(){
        return this.collection;
    }

    public AlarmDTO getAlarm(int i){
        return this.collection.get(i);
    }
}
