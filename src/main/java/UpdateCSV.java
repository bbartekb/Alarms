import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV extends Thread {
    private File file;
    String row;

    public UpdateCSV() throws IOException{


    }

    public void run() {
        BufferedReader csvRead = null;
        try {
            csvRead = new BufferedReader(new FileReader(Main.csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> list=new ArrayList<>();
        while (true) {
            try {
                if (!((row = csvRead.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(row);
            System.out.println(row);
        }
        try {
            csvRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        BufferedWriter csvWrite = null;
    }
}
