package Controller;

import models.GameObject;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public interface Colliable {

    void onCollide(Colliable c);
    GameObject getGameObject();
}
