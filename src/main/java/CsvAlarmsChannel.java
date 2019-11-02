import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvAlarmsChannel implements PropertyChangeListener {


    public void propertyChange(PropertyChangeEvent evt) {
        try {
            this.setAlarms();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setAlarms() throws IOException {
        List<AlarmBuilder> listOfAlarms = new ArrayList<>();
        ReaderCSV readerCSV = new ReaderCSV();
        List<List<String>> listCSV = readerCSV.getData();

        for(List<String> e: listCSV){
            listOfAlarms.add(new AlarmBuilder.Builder()
                    .notificationIdentifier(e.get(0))
                    .acknowledgeState(e.get(1))
                    .acknowledgeUserID(e.get(2))
                    .alertCount(Integer.getInteger(e.get(3)))
                    .moTTInfo(e.get(4))
                    .eventTime(e.get(5))
                    .build());
        }
        for(AlarmBuilder a: listOfAlarms) {
            System.out.println("działa dla CSV: " +a.getNotificationIdentifier());
        }
    }

}