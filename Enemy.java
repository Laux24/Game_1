import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends Entity{
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

    public Enemy(GamePanel mygp, String myName, int health, int damage, int magic){
        super(mygp);

        setDefaultVals();
        //getEnemyImage();
        direction= "up";

        //Make sure this isn't the whole sprite, you want to leave a little room
        solidAreaWidth=32;
        solidAreaHeight=32;
        solidArea=new Rectangle(x,y, solidAreaWidth, solidAreaHeight);
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
    }
    public void getEnemyImage(){
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

    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
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

    public void setAction(){
        actionLockCounter++;

        if (actionLockCounter==120){
            Random rand= new Randome();
            int i= rand.nextInt(100)+1;

            if (i<=25){
                direction="up";
            } else if (i<=50){
                direction="down";
            } else if (i<=75){
                direction="right";
            } else if (i<=100){
                direction="left";
            }

            actionLockCounter=0;
        }
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
