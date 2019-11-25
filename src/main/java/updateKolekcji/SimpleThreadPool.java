package updateKolekcji;

import updateKolekcji.UpdateCollectionAdd;
import updateKolekcji.UpdateCollectionRemove;
import updateKolekcji.UpdateCollectionUpdate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

    public SimpleThreadPool() throws InterruptedException {


Thread.sleep(3000);
        ExecutorService executor = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 10; i++) {
            Runnable workerAdd = new UpdateCollectionAdd();
            executor.execute(workerAdd);
            Thread.sleep(500);
            Runnable workerAdd2 = new UpdateCollectionAdd();
            executor.execute(workerAdd2);
            Thread.sleep(500);
            System.out.println("start of thread add" +i);
            Runnable workerRemove = new UpdateCollectionRemove();
            executor.execute(workerRemove);
            Thread.sleep(500);
            System.out.println("start of thread rem" +i);
            Runnable workerUpdate = new UpdateCollectionUpdate();
            executor.execute(workerUpdate);
            Thread.sleep(500);
            System.out.println("start of thread update" +i);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}