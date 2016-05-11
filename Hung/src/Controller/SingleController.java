package Controller;

import models.GameObject;
import models.GameVector;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class SingleController implements Controller {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;

    protected GameVector gameVector;


    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector(0,0);
    }

    public SingleController(GameObject gameObject, GameDrawer gameDrawer , GameVector gameVector) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = gameVector;
        this.gameVector = new GameVector(0,0);
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public void run() {
        gameObject.move(gameVector);
    }

    @Override
    public void paint(Graphics g) {
        gameDrawer.paint(this.gameObject, g);
    }
}
