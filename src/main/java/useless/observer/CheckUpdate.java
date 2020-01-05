package useless.observer;

import basic.AlarmsChannel;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class CheckUpdate extends Thread {
    private File file;
    private long lastUpdate;

    public CheckUpdate(File file, long lastUpdate) {
        this.file = file;
        this.lastUpdate = lastUpdate;
    }

    public void run() {
        FileObserver observable = new FileObserver();
        AlarmsChannel observer = new AlarmsChannel();
        observable.addObserver(observer);
        try {
            observable.setDate(this.lastUpdate);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for(int i = 0; i <= 60; ++i) {
            if (this.lastUpdate != this.file.lastModified()) {
                System.out.println("Zmiana");
                try {
                    observable.setDate(this.file.lastModified());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JAXBException | ParseException e) {
                    e.printStackTrace();
                }
            }

            this.lastUpdate = this.file.lastModified();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }
}

