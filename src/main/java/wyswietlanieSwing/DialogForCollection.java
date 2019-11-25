package wyswietlanieSwing;

import podstawa.AlarmsChannel;
import podstawa.Runner;
import updateKolekcji.SimpleThreadPool;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DialogForCollection extends JFrame implements ActionListener {
    JLabel title;
    JComboBox<String> path;
    JButton confirm;
    File selectedFile;
    BufferedReader csvRead;

    public DialogForCollection(){
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

            AlarmsChannel alarmsChannel = new AlarmsChannel();
            try {
                alarmsChannel.setAlarms();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (JAXBException ex) {
                ex.printStackTrace();
            }

            Runner.getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Runner.getWindow().setVisible(true);


            try {
                SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }



        }
    }
}
