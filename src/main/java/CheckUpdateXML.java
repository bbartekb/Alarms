import java.io.File;

public class CheckUpdateXML extends Thread {
    private File file;
    private long lastUpdate;

    public CheckUpdateXML(File file, long lastUpdate) {
        this.file = file;
        this.lastUpdate = lastUpdate;
    }

    public void run() {
        XmlFileObserver observable = new XmlFileObserver();
        XmlAlarmsChannel observer = new XmlAlarmsChannel();
        observable.addPropertyChangeListener(observer);
        observable.setDate(this.lastUpdate);

        for(int i = 0; i <= 40; ++i) {
            if (this.lastUpdate != this.file.lastModified()) {
                System.out.println("Zmiana");
                observable.setDate(this.file.lastModified());
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

