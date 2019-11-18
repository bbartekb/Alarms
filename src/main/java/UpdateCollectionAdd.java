public class UpdateCollectionAdd implements Runnable {
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            AlarmDTO alarmDTO;

                alarmDTO = new AlarmDTO.Builder()
                        .notificationIdentifier("test collection " + i)
                        .acknowledgeState("F")
                        .acknowledgeUserID("")
                        .alertCount("55")
                        .moTTInfo("")
                        .eventTime("2019-10-23 08:08:17")
                        .build();


            Main.collectionOfAlarms.add(alarmDTO);



        }

    }
}
