import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Dialog extends JFrame implements ActionListener {

    JLabel title;
    JComboBox<String> path;
    JButton confirm;
    File selectedFile;

    public Dialog() {
        setSize(400, 200);
        setTitle("Scieżka");
        setLayout(null);

        title = new JLabel("Wybierz ścieżkę do pliku:");
        title.setBounds(30, 10, 150, 40);
        add(title);

        path = new JComboBox<>();
        path.setBounds(30, 50, 300, 30);
        path.addItem("XML");
        path.addItem("CSV");
        add(path);
        path.setSelectedItem("CSV");


        confirm = new JButton("Potwierdz");
        confirm.setBounds(200, 90, 130, 30);
        confirm.addActionListener(this);
        add(confirm);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if(zrodlo==confirm) {
            Main.selectedFormat = path.getSelectedItem().toString();
            if(Main.selectedFormat.equals("XML")){
                selectedFile=Main.xmlFile;
                UpdateXML update = new UpdateXML();
                update.start();
            }
            else{
                selectedFile=Main.csvFile;
                UpdateCSV update = new UpdateCSV();
                update.start();
            }
                long fileUpdateTime = selectedFile.lastModified();
                CheckUpdate checkUpdeteThread = new CheckUpdate(selectedFile,fileUpdateTime);
                checkUpdeteThread.start();


         /*   else if(path.getSelectedItem().equals("XML")){
                Main.csvFile = new File(Main.csvPath);
                long csvUpdate = Main.csvFile.lastModified();
              //  CheckUpdateCSV csvThread = new CheckUpdateCSV(Main.csvFile,csvUpdate);
               // csvThread.start();


            }*/



            Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.window.setVisible(true);

        }
    }
}
