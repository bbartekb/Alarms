import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class Main {
    static String csvPath="";
    static String xmlPath="";
    static File csvFile;
    static File xmlFile;
    static Window window = new Window();

    public static void main(String arg[]) throws IOException, JAXBException, InterruptedException {


        Dialog dialog = new Dialog();
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setVisible(true);


    }
}
