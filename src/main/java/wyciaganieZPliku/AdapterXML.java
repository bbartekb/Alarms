package wyciaganieZPliku;

import podstawa.Runner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AdapterXML {

    private List<List<String>> listCSV;

    public AdapterXML() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(AlarmsXML.class);
        Unmarshaller um = context.createUnmarshaller();
        AlarmsXML alarms = (AlarmsXML) um.unmarshal(new FileReader(Runner.getSelectedFile()));

        List<List<String>> listXML = new ArrayList<>();
        for (AlarmXML alarm : alarms.getAlarms()) {
            List<String> temporary = new ArrayList<>();
            for (AlarmAttribute attribute : alarm.getRecord()) {
                temporary.add(attribute.getValue());
            }
            listXML.add(temporary);
        }
        this.listCSV=listXML;
    }

    public List<List<String>> getListXML(){
        return listCSV;
    }
}
