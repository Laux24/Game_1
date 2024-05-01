import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class Entity {
    public int x, y;
    public int speed;

    //public URL right, left;
    public String direction;

    GamePanel gp;
    public Rectangle solidArea;
    public int solidAreaWidth;
    public int solidAreaHeight;
    public boolean collisionOn=false;
    public int actionLockCounter=0;

    public Entity(GamePanel mygp){
        this.gp=mygp;
    }

    public void update(){
        // setAction();
        // System.out.println("Xoro");
        collisionOn=false;

        // if (collisionOn==false){
        //     switch(direction){
        //         case "up": y-= speed; 
        //         case "down": y+= speed;
        //         case "right": x+= speed;
        //         case "left": x-= speed;
        //     }
        // }
    }

    public void bye(){
        
    }

    
}
