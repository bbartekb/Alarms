import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Dialog extends JFrame implements ActionListener {

    JLabel title;
    TextField path;
    JButton confirm;

    public Dialog() {
        setSize(400, 200);
        setTitle("Scieżka");
        setLayout(null);

        title = new JLabel("Podaj ścieżkę do pliku:");
        title.setBounds(30, 10, 150, 40);
        add(title);

        path = new TextField("");
        path.setBounds(30, 50, 300, 30);
        add(path);

        confirm = new JButton("Potwierdz");
        confirm.setBounds(200, 90, 130, 30);
        confirm.addActionListener(this);
        add(confirm);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if(zrodlo==confirm) {
            String newPath = path.getText();
            String format = newPath.substring(newPath.length()-3,newPath.length());
            String csv = "csv";
            String xml = "xml";
            if (format.equals(csv)){
                Main.csvPath=newPath;
            }
            else{
                Main.xmlPath=newPath;
            }
            System.out.println(format);
            dispose();
            Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.window.setVisible(true);
            if(Main.csvPath.length()!=0) {
                Main.csvFile = new File(Main.csvPath);
                long csvUpdate = Main.csvFile.lastModified();
                CheckUpdateCSV csvThread = new CheckUpdateCSV(Main.csvFile,csvUpdate);
                csvThread.start();

                UpdateCSV update = new UpdateCSV();
                update.start();

            }
            else{
                Main.xmlFile = new File(Main.xmlPath);
                long xmlUpdate = Main.xmlFile.lastModified();
                CheckUpdateXML xmlThread = new CheckUpdateXML(Main.xmlFile,xmlUpdate);
                xmlThread.start();

                UpdateXML update = new UpdateXML();
                update.start();
            }



            Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.window.setVisible(true);

        }
    }
}
