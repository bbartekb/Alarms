package swingdisplaying;

import basic.AlarmsChannel;
import basic.MOsChannel;
import basic.Runner;
import dtoobjects.TypeOfObjects;
import updateobject.ThreadPoolForAlarms;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DialogForCollection extends JFrame implements ActionListener {
    JLabel title;
    JLabel data;
    JComboBox<String> path;
    JComboBox<String> type;
    JButton confirm;
    File selectedFile;
    BufferedReader csvRead;

    public  DialogForCollection(){
        setSize(400, 280);
        setTitle("Scieżka");
        setLayout(null);

        title = new JLabel("Wybierz ścieżkę do pliku:");
        title.setBounds(30, 10, 150, 40);
        add(title);

        data = new JLabel("Wybierz typ dancyh:");
        data.setBounds(30, 100, 150, 40);
        add(data);

        path = new JComboBox<>();
        path.setBounds(30, 50, 300, 30);
        path.addItem("XML");
        path.addItem("CSV");
        add(path);
        path.setSelectedItem("CSV");

        type = new JComboBox<>();
        type.setBounds(30, 140, 300, 30);
        type.addItem("Ticket");
        type.addItem("Alarm");
        add(type);
        type.setSelectedItem("Ticket");


        confirm = new JButton("Potwierdz");
        confirm.setBounds(200, 185, 130, 30);
        confirm.addActionListener(this);
        add(confirm);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if(zrodlo==confirm) {

            Runner.setSelectedFile(path.getSelectedItem().toString(),type.getSelectedItem().toString());
            Runner.getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Runner.getWindow().setVisible(true);

            if(Runner.getSelectedTypeOfData().equals(TypeOfObjects.ALARM)) {

                AlarmsChannel alarmsChannel = new AlarmsChannel();
                try {
                    alarmsChannel.setAlarms();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }
            else{
                MOsChannel mOsChannel=new MOsChannel();
                try {
                    mOsChannel.setAlarms();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }

            try {
                ThreadPoolForAlarms threadPoolForAlarms = new ThreadPoolForAlarms();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }



        }
    }
}
