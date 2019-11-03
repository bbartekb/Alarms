import java.io.File;

class CheckUpdateCSV extends Thread {
    private File file;
    private long lastUpdate;

    public CheckUpdateCSV(File file, long lastUpdate) {
        this.file = file;
        this.lastUpdate = lastUpdate;
    }

    public void run() {
        CsvFileObserver observable = new CsvFileObserver();
        CsvAlarmsChannel observer = new CsvAlarmsChannel();
        observable.addPropertyChangeListener(observer);
        observable.setDate(this.lastUpdate);

        for(int i = 0; i <= 60; i++) {
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

