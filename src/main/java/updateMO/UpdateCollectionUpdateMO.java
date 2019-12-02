package updateMO;
import dtoobjects.MoDTO;
import basic.Runner;

public class UpdateCollectionUpdateMO extends Thread {

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
            MoDTO.Builder moDTO = new MoDTO.Builder().from((MoDTO) Runner.getCollection().getObject(random));
            moDTO.resource("ticket: "+i);
            Runner.getCollection().remove(random);
            Runner.getCollection().add(moDTO.build(),random);

        }

    }
}
