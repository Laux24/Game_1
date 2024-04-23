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

    public void update(){
        //setAction();

        collisionOn=false;
        gp.cChecker.checkEntity(this, gp.red);

        if (collisionOn==false){
            switch(direction){
                case "up": y-= speed;
                case "down": y+= speed;
                case "right": x+= speed;
                case "left": x-= speed;
            }
    }
}
}
