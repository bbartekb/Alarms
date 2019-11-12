import java.text.ParseException;

public class UpdateCollectionUpdate extends Thread {

    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AlarmDTO.Builder alarmDTO = new AlarmDTO.Builder().from(Main.collectionOfAlarms.getAlarm(7));
            alarmDTO.moTTInfo("ticket: "+i);
            Main.collectionOfAlarms.remove(7);
            Main.collectionOfAlarms.add(alarmDTO.build(),7);

        }

    }
}
