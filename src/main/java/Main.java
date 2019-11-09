import javax.swing.*;
import java.io.File;

public class Main {
    static String selectedFormat;
    static final String csvPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.csv";
    static final String xmlPath="C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml";
    static final File csvFile = new File (csvPath);
    static File xmlFile = new File(xmlPath);
    static Window window = new Window();

    public static void main(String arg[]){


        Dialog dialog = new Dialog();
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setVisible(true);


    }
}
