package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public interface GameDrawer {
    void paint(GameObject gameObject, Graphics g);
}
