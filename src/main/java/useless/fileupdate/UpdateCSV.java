package useless.fileupdate;

import basic.Runner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV extends Thread {
    private File file;
    String row;

    public void run() {
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BufferedReader csvRead = null;
            try {
                csvRead = new BufferedReader(new FileReader(Runner.getSelectedFile()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            List<String> list=new ArrayList<>();
            try{
                while((row = csvRead.readLine()) != null){
                    list.add(row);
                }
                csvRead.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            String header = list.get(0);
            list.remove(0) ;
            FileWriter csvWrite = null;

            try {
                csvWrite = new FileWriter(Runner.csvPath);
                csvWrite.write(header);
                csvWrite.write(System.lineSeparator());
                csvWrite.write("\"test_bb_"+i+"\";\"F\";\"\";\"5\";\"\";\"2019-10-23 09:16:24\"");
                for(String s: list){
                    csvWrite.write(System.lineSeparator());
                    csvWrite.write(s);
                }
                csvWrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
