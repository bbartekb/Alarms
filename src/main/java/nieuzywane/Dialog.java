/*
package nieuzywane;

import nieuzywane.observer.CheckUpdate;
import podstawa.Runner;
import nieuzywane.updatePlikow.UpdateCSV;
import nieuzywane.updatePlikow.UpdateXML;

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
            Runner.setSelectedFile(path.getSelectedItem().toString());
            if(path.getSelectedItem().toString().equals("XML")){
                UpdateXML update = new UpdateXML();
                update.start();
            }
            else{
                UpdateCSV update = new UpdateCSV();
                update.start();
            }

                long fileUpdateTime = selectedFile.lastModified();
                CheckUpdate checkUpdeteThread = new CheckUpdate(selectedFile,fileUpdateTime);
                checkUpdeteThread.start();



            Runner.getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Runner.getWindow().setVisible(true);

        }
    }
}
*/
