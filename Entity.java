import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class Entity {
    public int x, y;
    public int speed;

    //public URL right, left;
    public String direction;

    public Rectangle solidArea;
    public boolean collisionOn=false;
    public int actionLockCounter=0;

    public Entity(Gamepanel mygp){
        this.gp=mygp;
    }
}
