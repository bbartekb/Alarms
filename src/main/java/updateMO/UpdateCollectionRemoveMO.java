package updateMO;
import basic.Runner;

public class UpdateCollectionRemoveMO implements Runnable  {

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double losowa = Math.random()*13;
            int random= (int) losowa;
            Runner.getCollection().remove(random);
        }

    }
}
