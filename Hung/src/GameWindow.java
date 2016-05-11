import Controller.PlayerController;
import Controller.PlayerDirection;
import Controller.SpermControllerManager;
import models.GameConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class GameWindow extends Frame implements Runnable {
    GameConfig gameConfig;
    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    SpermControllerManager spermControllerManager;

    PlayerController playerController;
    public GameWindow(){
        this.gameConfig = GameConfig.getInst();

        this.setVisible(true);
        this.setSize(gameConfig.getScreenWidth(),
                gameConfig.getScreenHeight());

        this.playerController = PlayerController.getPlayerController();
        this.spermControllerManager = SpermControllerManager.getInst();
        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {

                PlayerDirection playerDirection = PlayerDirection.NONE;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        playerDirection = playerDirection.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        playerDirection = playerDirection.RIGHT;
                        break;
                }

                playerController.move(playerDirection);
                /*TODO static explanation*/
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("keyReleased");

                PlayerDirection playerDirection = PlayerDirection.NONE;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        playerDirection = playerDirection.STOP_X;
                        break;
                }
                playerController.move(playerDirection);
            }
        });
        thread = new Thread(this);
        thread.start();
    }
    public void update(Graphics g) {

        if(backbufferImage == null){
            backbufferImage =  new BufferedImage(gameConfig.getScreenWidth(),
                    gameConfig.getScreenHeight(), 1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), null);
        spermControllerManager.paint(backbufferGraphics);
        playerController.paint(backbufferGraphics);;
        g.drawImage(backbufferImage, 0, 0, null);
    }
    @Override
    public void run() {
        while(true){
            try {

                playerController.run();
                spermControllerManager.run();
                repaint();
                Thread.sleep(GameConfig.DEFAULT_THREAD_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
