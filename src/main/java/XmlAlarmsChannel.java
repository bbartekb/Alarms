import javax.xml.bind.JAXBException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlAlarmsChannel implements PropertyChangeListener {


    public void propertyChange(PropertyChangeEvent evt) {
        try {
            this.setAlarms();
        } catch (IOException | JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void setAlarms() throws IOException, JAXBException {
        AdapterXML adapterXML = new AdapterXML();
        List<List<String>> listXML = adapterXML.getListXML();

        List<AlarmBuilder> listOfAlarms = new ArrayList<>();
        for(List<String> e: listXML){
            listOfAlarms.add(new AlarmBuilder.Builder()
                    .notificationIdentifier(e.get(0))
                    .acknowledgeState(e.get(1))
                    .acknowledgeUserID(e.get(2))
                    .alertCount(e.get(3))
                    .moTTInfo(e.get(4))
                    .eventTime(e.get(5))
                    .build());
        }
        Main.window.setParameters(listOfAlarms);
    }

}