package updateMO;
import dtoobjects.MoDTO;
import basic.Runner;

public class UpdateCollectionAddMO implements Runnable {
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MoDTO moDTO;

                moDTO = new MoDTO.Builder()
                        .identifier("test mo " + i)
                        .resource("Test Resource")
                        .lifecycleState("Active")
                        .description("test Description")
                        .xCreateUser("Ja")
                        .xCreateDate("2019-10-23 08:08:17")
                        .build();


            Runner.getCollection().add(moDTO);



        }

    }
}
