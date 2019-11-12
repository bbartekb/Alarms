import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AlarmsChannel {


    public void setAlarms() throws IOException, JAXBException, ParseException {
        List<List<String>> listCSV;
        if(Main.selectedFormat.equals("XML")){
            AdapterXML adapterXML = new AdapterXML();
            listCSV = adapterXML.getListXML();
        }
        else{
            ReaderCSV readerCSV = new ReaderCSV();
            listCSV = readerCSV.getData();
        }

        List<AlarmDTO> listOfAlarms = new ArrayList<>();
        for(List<String> e: listCSV){
            listOfAlarms.add(new AlarmDTO.Builder()
                    .notificationIdentifier(e.get(0))
                    .acknowledgeState(e.get(1))
                    .acknowledgeUserID(e.get(2))
                    .alertCount(e.get(3))
                    .moTTInfo(e.get(4))
                    .eventTime(e.get(5))
                    .build());
        }

        // tu dla dialog 2 sobie tworzę kolekcję z alarmami
        Main.collectionOfAlarms.setCollection(listOfAlarms);

        // nie wiem czy w tym miejscu będę to odpalał
        Main.window.setParameters(listOfAlarms);
    }

}