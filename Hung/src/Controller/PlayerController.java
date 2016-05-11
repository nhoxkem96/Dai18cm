package Controller;

import models.BCS;
import models.GameConfig;
import models.Sperm;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class PlayerController extends SingleControllerWithHP implements Colliable {
    public final int SPEED = 10;


    private PlayerController(BCS gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public void move(PlayerDirection planeDirection) {
        switch (planeDirection) {
            case NONE:
                break;
            case LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case STOP_X:
                this.gameVector.dx = 0;
        }

    }


    private static PlayerController playerController;

    public static PlayerController getPlayerController() {
        if (playerController == null) {
            BCS plane = new BCS(100, 500, 70, 60);
            ImageDrawer planeDrawer = new ImageDrawer("resources/BCS.png");
            playerController = new PlayerController(plane, planeDrawer);
        }
        return playerController;
    }

    @Override
    public void run() {
        if (this.gameObject.isAlive()) {
            Rectangle rectangle=this.gameObject.getNextRect(this.gameVector);
            if(GameConfig.getInst().isInScreen(rectangle)) {
                super.run();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (this.gameObject.isAlive()) {
            super.paint(g);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof SpermController) {
            Sperm sperm = (Sperm) c.getGameObject();
            sperm.setAlive(false);
        }
        if(this.getBCS().getHp() <= 0){
            this.gameObject.setAlive(false);
        }
    }
}
