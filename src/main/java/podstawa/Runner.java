package podstawa;

import kolekcjaAlarmow.CollectionOfAlarms;
import kolekcjaAlarmow.ConcurrentCollectionOfAlarms;
import kolekcjaAlarmow.InterfaceCollection;
import wyswietlanieSwing.DialogForCollection;
import wyswietlanieSwing.Window;

import javax.swing.*;
import java.io.File;

public class Runner{
    public static final String csvPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.csv";
    public static final String xmlPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml";
    static final Window window = new Window();
    private static CollectionOfAlarms collectionOfAlarms = new CollectionOfAlarms();
    private static ConcurrentCollectionOfAlarms concurrentCollectionOfAlarms=new ConcurrentCollectionOfAlarms();
    private static File selectedFile;
    private static String selectedFormat;

    public Runner(){
        DialogForCollection dialog = new DialogForCollection();
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setVisible(true);
    }


    public static void setSelectedFile(String s) {
     if(s.equals("XML")){
         selectedFile=new File(xmlPath);
     }
     else{
         selectedFile=new File(csvPath);
     }
     selectedFormat=s;
    }

    public static File getSelectedFile(){
        return selectedFile;
    }

    public static String getSelectedFormat(){
        return selectedFormat;
    }

    public static InterfaceCollection getCollection(){
        //Tu decyduję ktróa lista
    return concurrentCollectionOfAlarms;
    }

    public static Window getWindow(){
        return window;
    }


}
