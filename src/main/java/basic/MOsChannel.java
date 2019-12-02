package basic;

import dtoobjects.MoDTO;
import importfromfile.AdapterXML;
import importfromfile.ReaderCSV;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MOsChannel {


    public void setAlarms() throws IOException, JAXBException {
        List<List<String>> listCSV;
        if(Runner.getSelectedFormat().equals("XML")){
                AdapterXML adapterXML = new AdapterXML();
                listCSV = adapterXML.getListXML();

        }
        else{
                ReaderCSV readerCSV = new ReaderCSV();
                listCSV = readerCSV.getData();
        }

        List<MoDTO> listOfMO = new ArrayList<>();
        for(List<String> e: listCSV){
            listOfMO.add(new MoDTO.Builder()
                    .identifier(e.get(0))
                    .resource(e.get(1))
                    .lifecycleState(e.get(2))
                    .description(e.get(3))
                    .xCreateDate(e.get(4))
                    .xCreateUser(e.get(5))
                    .build());
        }

        Runner.getCollection().setCollectionA(listOfMO);
    }

}