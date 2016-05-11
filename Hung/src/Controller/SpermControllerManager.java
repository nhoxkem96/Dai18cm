package Controller;

import models.GameConfig;

import java.util.Random;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class SpermControllerManager extends ControllerManager {
    private int count = 0;
    Random rand = new Random();
    private int n = rand.nextInt(500) + 1;
    public SpermControllerManager(){
        super();
    }

    @Override
    public void run() {
        super.run();
        count ++;
        if(GameConfig.getInst().durationInMiliseconds(count) > n){
            count = 0;
            n = rand.nextInt(500) + 1;
            int count2 = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH /2) + 1;// Random vi tri X cua Sperm
            this.singleControllerVector.add(SpermController.create(count2 , 0));

        }
    }
    private static SpermControllerManager inst;
    public static SpermControllerManager getInst() {
        if(inst == null) {
            inst = new SpermControllerManager();
        }

        return inst;
    }
}
