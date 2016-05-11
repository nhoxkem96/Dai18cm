package Controller;

import models.GameConfig;
import models.GameVector;
import models.Sperm;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class SpermController extends SingleController{

    private static int speed = 5;
    private int count = 0;

    public SpermController(Sperm gameObject,
                                GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = speed;
       // CollisionPool.getInst().add(this);
    }

    public SpermController(Sperm gameObject,
                                GameDrawer gameDrawer,
                                GameVector gameVector) {
        super(gameObject, gameDrawer);
        this.gameVector = gameVector;
        //CollisionPool.getInst().add(this);
    }



    @Override
    public void run() {
        super.run();

        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
            //PlayerController.getPlayerController().getBCS().decreaseHP();
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

//    @Override
//    public void onCollide(Colliable c) {
//        if(c instanceof PlaneController){
//            Plane plane=(Plane)c.getGameObject();
//            plane.decreaseHP(2);
//        }
//    }


    public static SpermController create(int x, int y) {
        Sperm sperm = new Sperm(x,y,Sperm.WIDTH_DEFAULT, Sperm.HEIGHT_DEFAULT);
        SpermController spermController = null;
        GameVector gameVector = null;


//        switch (enemyPlaneType){
//            case BLACK:
//                ImageDrawer blackPlaneDrawer =
//                        new ImageDrawer("resources/plane1.png");
//                gameVector = new GameVector(0, 2);
//                enemyPlaneController =
//                        new EnemyPlaneController(
//                                enemyPlane,
//                                blackPlaneDrawer,
//                                gameVector,
//                                new EnemyDirectShotBehavior());
//                break;
//            case WHITE:
//                ImageDrawer whitePlaneDrawer =
//                        new ImageDrawer("resources/enemy_plane_white_1.png");
//                gameVector = new GameVector(2, 2);
//                enemyPlaneController = new EnemyPlaneController(enemyPlane, whitePlaneDrawer, gameVector);
//                break;
//        }
        ImageDrawer spermDrawer =
                        new ImageDrawer("resources/Sperm.png");
                gameVector = new GameVector(0, SpermController.speed);
                spermController =
                        new SpermController(
                                sperm,
                                spermDrawer,
                                gameVector);
        return spermController;
    }



}
