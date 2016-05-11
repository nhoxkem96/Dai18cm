package models;

/**
 * Created by nhoxkem96 on 11/05/2016.
 */
public class BCS extends GameObjectWithHP{
    private static int hp = 5;
    private int score = 0;

    public BCS(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public int getScore() {
        return score;
    }

    @Override
    public static int getHp() {
        return hp;
    }

    @Override
    public static void setHp(int hp) {
        BCS.hp = hp;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public BCS(int x, int y, int width, int height) {
        this(x, y, width, height, hp);
    }
}
