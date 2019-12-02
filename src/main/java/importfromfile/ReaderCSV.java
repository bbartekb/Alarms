package importfromfile;

import basic.Runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderCSV {

    List<List<String>> records = new ArrayList<>();

    public ReaderCSV() throws IOException {
        BufferedReader csvRead = new BufferedReader(new FileReader(Runner.getSelectedFile()));
        String row;
        while ((row = csvRead.readLine()) != null) {
            String[] data = row.split(";");
            if(Runner.getTypeOfData().equals("Alarm")){
                for(int i=1; i<data.length;i++){
                    data[i]=data[i].substring(1,data[i].length()-1);
                }
            }
            records.add(Arrays.asList(data));
        }
        csvRead.close();
        records.remove(0);
    }

    public List<List<String>> getData(){
        return records;
    }
}