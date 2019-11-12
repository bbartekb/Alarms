import java.util.ArrayList;
import java.util.List;

public class CollectionOfAlarms {
    private List<AlarmDTO> collection= new ArrayList<>();


    public void setCollection(List<AlarmDTO> collection) {
        this.collection = collection;
    }

    public void add(AlarmDTO alarm){
        this.collection.add(alarm);
        Main.window.setParameters(this.collection);
    }

    public void remove(int i){
        this.collection.remove(i);
        Main.window.setParameters(this.collection);
    }

    public void add (AlarmDTO alarm, int i){
        this.collection.add(i,alarm);
        Main.window.setParameters(this.collection);

    }

    public List<AlarmDTO> getCollection(){
        return this.collection;
    }

    public AlarmDTO getAlarm(int i){
        return this.collection.get(i);
    }
}
