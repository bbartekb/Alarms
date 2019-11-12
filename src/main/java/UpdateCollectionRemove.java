public class UpdateCollectionRemove extends Thread  {

    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Main.collectionOfAlarms.remove(3);
        }

    }
}
