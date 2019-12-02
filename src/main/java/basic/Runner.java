package basic;

//import nieuzywane.CollectionOfAlarms;
import objectscollection.CollectionOfObjects;
//import nieuzywane.ConcurrentCollectionOfAlarms;
import swingdisplaying.DialogForCollection;
import swingdisplaying.Window;

import javax.swing.*;
import java.io.File;

public class Runner{
    private static  String typeOfData;
    public static final String csvPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.csv";
    public static final String xmlPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml";
    public static final String csvMOPath="C:\\Dysk_D\\pliki_do_projektu\\mo2.csv";
    public static final String xmlMOPath="C:\\Dysk_D\\pliki_do_projektu\\mo2.xml";
    static final Window window = new Window();
 //   private static CollectionOfAlarms collectionOfAlarms = new CollectionOfAlarms();
    private static CollectionOfObjects collectionOfObjects = new CollectionOfObjects();
  //  private static ConcurrentCollectionOfAlarms concurrentCollectionOfAlarms=new ConcurrentCollectionOfAlarms();
    private static File selectedFile;
    private static String selectedFormat;

    public Runner(){
        DialogForCollection dialog = new DialogForCollection();
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setVisible(true);
    }


    public static void setSelectedFile(String s, String type) {
     if(type=="Alarm"){
         if(s.equals("XML")){
             selectedFile=new File(xmlPath);
         }
         else{
             selectedFile=new File(csvPath);
         }
     }
     else{
         if(s.equals("XML")){
             selectedFile=new File(xmlMOPath);
         }
         else{
             selectedFile=new File(csvMOPath);
         }
     }
     selectedFormat=s;
     typeOfData=type;
     }

    public static File getSelectedFile(){
        return selectedFile;
    }

    public static String getSelectedFormat(){
        return selectedFormat;
    }


    public static String getTypeOfData(){
        return typeOfData;
    }

    public static void setTypeOfData(String s){
        typeOfData=s;
    }

    public static CollectionOfObjects getCollection(){
        //Tu decyduję ktróa lista
    return collectionOfObjects;
    }

    public static Window getWindow(){
        return window;
    }



}
