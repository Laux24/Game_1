import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public String name;
    public int hp;
    public int dp;
    public int mp;

    public Player(GamePanel mygp, KeyHandler mykeyH, String myName, int health, int damage, int magic){
        gp=mygp;
        keyH=mykeyH;

        setDefaultVals();
        getPlayerImage();

        name=myName;
        hp=health;
        dp=damage;
        mp=magic;
    }

    public void setDefaultVals(){
        int x=100;
        int y=100;
        int speed=4;
    }
    public void getPlayerImage(){
        try{
            // right=MyClass.class.getResource("Spork_Knight.gif");
            // ImageIcon iI= new ImageIcon(right);
            // JLabel label=new JLabel(iI);
            // label.setBounds(x,y,gp.tileSize,gp.tileSize);
            // window.frame.getContentPane().add(label);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
         if (keyH.upPressed==true){
            direction="up";
            y-= speed;
        }
        if (keyH.downPressed==true){
            direction="down";
            y+= speed;
        }
        if (keyH.rightPressed==true){
            direction="right";
            x+= speed;
        }
        if (keyH.leftPressed==true){
            direction="left";
            x-= speed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x,y,gp.tileSize, gp.tileSize);

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