package updateAlarmow;
import dto.AlarmDTO;
import podstawa.Runner;

public class UpdateCollectionUpdateAlarm extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double losowa = Math.random()*13;
            int random= (int) losowa;
            Runner.getCollection().remove(random);
            AlarmDTO.Builder alarmDTO = new AlarmDTO.Builder().from((AlarmDTO) Runner.getCollection().getAlarm(random));
            alarmDTO.moTTInfo("ticket: "+i);
            Runner.getCollection().remove(random);
            Runner.getCollection().add(alarmDTO.build(),random);

        }

    }
}
