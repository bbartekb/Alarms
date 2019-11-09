import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlarmsChannel {


    public void setAlarms() throws IOException, JAXBException {
        List<List<String>> listCSV;
        if(Main.selectedFormat.equals("XML")){
            AdapterXML adapterXML = new AdapterXML();
            listCSV = adapterXML.getListXML();
        }
        else{
            ReaderCSV readerCSV = new ReaderCSV();
            listCSV = readerCSV.getData();
        }

        List<AlarmBuilder> listOfAlarms = new ArrayList<>();
        for(List<String> e: listCSV){
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