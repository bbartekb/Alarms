package updatePlikow;

import podstawa.Runner;
import wyciaganieZPliku.AlarmAttribute;
import wyciaganieZPliku.AlarmXML;
import wyciaganieZPliku.AlarmsXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UpdateXML extends Thread {


    public void run() {

        try {
            JAXBContext context = JAXBContext.newInstance(AlarmsXML.class);
            Unmarshaller um = context.createUnmarshaller();
            AlarmsXML alarms = (AlarmsXML) um.unmarshal(new FileReader("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml"));
            Marshaller jaxbMarshaller = context.createMarshaller();

            for (int i = 0; i <= 10; i++) {
                Thread.sleep(5000);
                List<AlarmAttribute> listOfAttributes = new ArrayList<>();

                AlarmAttribute alarmAtt1 = new AlarmAttribute();
                alarmAtt1.setName("Notification Identifier");
                alarmAtt1.setValue("Test" + i);

                AlarmAttribute alarmAtt2 = new AlarmAttribute();
                alarmAtt2.setName("Acknowledge State");
                alarmAtt2.setValue("T");

                AlarmAttribute alarmAtt3 = new AlarmAttribute();
                alarmAtt3.setName("Acknowledge User ID");
                alarmAtt3.setValue("bb1");

                AlarmAttribute alarmAtt4 = new AlarmAttribute();
                alarmAtt4.setName("Alert Count");
                alarmAtt4.setValue("22");

                AlarmAttribute alarmAtt5 = new AlarmAttribute();
                alarmAtt5.setName("MO TT Info");
                alarmAtt5.setValue("");

                AlarmAttribute alarmAtt6 = new AlarmAttribute();
                alarmAtt6.setName("Event Time");
                alarmAtt6.setValue("2019-10-23 08:08:17");

                listOfAttributes.add(alarmAtt1);
                listOfAttributes.add(alarmAtt2);
                listOfAttributes.add(alarmAtt3);
                listOfAttributes.add(alarmAtt4);
                listOfAttributes.add(alarmAtt5);
                listOfAttributes.add(alarmAtt6);

                AlarmXML newAlarm = new AlarmXML();
                newAlarm.setRecord(listOfAttributes);
                alarms.addAlarm(newAlarm);
                jaxbMarshaller.marshal(alarms, new File(Runner.xmlPath));
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
