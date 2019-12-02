package updateobject;
import dtoobjects.AlarmDTO;
import basic.Runner;
import dtoobjects.MoDTO;

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
            if(Runner.getTypeOfData().equals("Alarm")){
                AlarmDTO.Builder alarmDTO = new AlarmDTO.Builder().from((AlarmDTO) Runner.getCollection().getObject(random));
                alarmDTO.moTTInfo("ticket: "+i);
                Runner.getCollection().remove(random);
                Runner.getCollection().add(alarmDTO.build(),random);
            }
            else{
                MoDTO.Builder moDTO = new MoDTO.Builder().from((MoDTO) Runner.getCollection().getObject(random));
                moDTO.resource("Resource: "+i);
                Runner.getCollection().remove(random);
                Runner.getCollection().add(moDTO.build(),random);
            }

        }

    }
}
