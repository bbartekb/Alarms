public class UpdateCollectionUpdate extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double losowa = Math.random()*13;
            int random= (int) losowa;
            Main.collectionOfAlarms.remove(random);
            AlarmDTO.Builder alarmDTO = new AlarmDTO.Builder().from(Main.collectionOfAlarms.getAlarm(random));
            alarmDTO.moTTInfo("ticket: "+i);
            Main.collectionOfAlarms.remove(random);
            Main.collectionOfAlarms.add(alarmDTO.build(),random);

        }

    }
}
