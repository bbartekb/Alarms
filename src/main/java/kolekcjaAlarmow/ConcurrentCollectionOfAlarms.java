package kolekcjaAlarmow;

import dto.AlarmDTO;
import podstawa.Runner;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionOfAlarms implements InterfaceCollection {
    private CopyOnWriteArrayList<AlarmDTO> collection=new CopyOnWriteArrayList<>();

    @Override
    public void add(AlarmDTO alarm) {
        this.collection.add(alarm);
        Runner.getWindow().setParameters(this.collection);
    }

    @Override
    public void remove(int i) {
        this.collection.remove(i);
        Runner.getWindow().setParameters(this.collection);
    }

    @Override
    public void add(AlarmDTO alarm, int i) {
        this.collection.add(i,alarm);
        Runner.getWindow().setParameters(this.collection);
    }

    @Override
    public List<AlarmDTO> getCollection() {
            return this.collection;
    }

    @Override
    public AlarmDTO getAlarm(int i) {
        return this.collection.get(i);
    }

    @Override
    public void setCollection(List<AlarmDTO> listOfAlarms) {
        this.collection.addAll(listOfAlarms);
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
}
