import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileObserver {
    private Long date;
    private List<AlarmsChannel> observers=new ArrayList<>();

    public FileObserver(){
    }

    public void addObserver(AlarmsChannel observer) {
        this.observers.add(observer);
    }

    public void removeObserver(AlarmsChannel observer) {
        this.observers.remove(observer);
    }

    public void setDate (Long date) throws IOException, JAXBException {
        this.date=date;
        for (AlarmsChannel observer : this.observers) {
            observer.setAlarms();
        }
    }
}