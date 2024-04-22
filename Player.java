import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public int x;
    public int y;
    public int speed;
    public String direction;
    public String name;
    public int hp;
    public int dp;
    public int mp;

    public Player(GamePanel mygp, KeyHandler mykeyH, String myName, int health, int damage, int magic){
        gp=mygp;
        keyH=mykeyH;

        setDefaultVals();
        getPlayerImage();
        direction="up";

        //Make sure this isn't the whole sprite, you want to leave a little room
        //solidArea=new Rectangle(0,0, 50, 50);
        //You can also do this:
        //solidArea.x / y / height / width = #

        name=myName;
        hp=health;
        dp=damage;
        mp=magic;
    }

    public void setDefaultVals(){
        x=100;
        y=100;
        speed=4;
        // String direction="north";
    }
    public void getPlayerImage(){
        // try{
        //     // right=MyClass.class.getResource("Spork_Knight.gif");
        //     // ImageIcon iI= new ImageIcon(right);
        //     // JLabel label=new JLabel(iI);
        //     // label.setBounds(x,y,gp.tileSize,gp.tileSize);
        //     // window.frame.getContentPane().add(label);
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
    }

    public void update(){
         //String direction;
        if (keyH.upPressed==true){
            direction="up";
            //System.out.println("up");
            y-= speed;
            // System.out.println("y: "+y);
        }
        if (keyH.downPressed==true){
            direction="down";
            y+= speed;
            // System.out.println("y: "+y);
        }
        if (keyH.rightPressed==true){
            direction="right";
            x+= speed;
            // System.out.println("x: "+x);
        }
        if (keyH.leftPressed==true){
            direction="left";
            x-= speed;
            // System.out.println("x: "+x);
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(x,y,gp.tileSize, gp.tileSize);
        g2.dispose();

        //BufferedImage image=null;
        // switch(direction){
        //     case "right":
        //         image= right;
        //         break;
        //     case "left":
        //         image=left;
        //         break;
        // }
        //g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public String getName(){
        return name;
    }
    public int getHP(){
        return hp;
    }
    public int  getDP(){
        return dp;
    }
    public int getMP(){
        return mp;
    }
    public void setHP(int health){
         hp= health;
    }
    public void setDP(int damage){
        dp= damage;
    }
    public void setMP(int magic){
     mp= magic;
}
    public String toString(){
        return name+", Health: "+hp+", damage: "+dp+" magic: "+mp;
    }
}