package Controller;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class SingleControllerWithHP extends SingleController {

    public SingleControllerWithHP(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }
//    public BCS getBCS(){
//        BCS bcs = (BCS) this.getGameObject();
//        return bcs;
//    }
}
