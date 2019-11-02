import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class Main {
    static File csvPath;
    static File xmlPath;
    public static void main(String arg[]) throws IOException, JAXBException, InterruptedException {
        csvPath = new File("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe.csv");
        long csvUpdate = csvPath.lastModified();
        xmlPath = new File("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe.xml");
        long xmlUpdate = xmlPath.lastModified();

        System.out.println("aaa");
        CheckUpdateCSV csvThread = new CheckUpdateCSV(csvPath,csvUpdate);
        CheckUpdateXML xmlThread = new CheckUpdateXML(xmlPath,xmlUpdate);
        csvThread.start();
        xmlThread.start();

    }
}
