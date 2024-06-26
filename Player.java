import java.awt.Color;
import java.awt.Container;
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
    KeyHandler keyH;
    public int x;
    public int y;
    public int speed;
    public String direction;
    public String name;
    public int hp;
    public int dp;
    public int mp;
    public int size;

    public Player(GamePanel gp, KeyHandler mykeyH, String myName, int health, int damage, int magic){
        super(gp);
        keyH=mykeyH;

        setDefaultVals();
        //getPlayerImage();
        direction="up";

        //Make sure this isn't the whole sprite, you want to leave a little room
        size= 40;
        solidArea=new Rectangle(x,y, size, size);
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
            // System.out.println("y: "+y);
            y-= speed; 
        }
        if (keyH.downPressed==true){
            direction="down";
            // System.out.println("y: "+y);
            y+= speed;
        }
        if (keyH.rightPressed==true){
            direction="right";
            // System.out.println("x: "+x);
            x+= speed;
        }
        if (keyH.leftPressed==true){
            direction="left";
            // System.out.println("x: "+x);
            x-= speed;
        }

        collisionOn=false;

        
        
    }

    public void bye(){
        //Dieicide
        x=1000;
    }

    public boolean checkEntity(Entity me, Entity them){
        
        // int index=999;
        // if (this.getClass() instanceOf Enemy)
        if (them!=null){
            

            int myXArea1=me.solidArea.x;
            int myYArea1=me.solidArea.y;
            int myXArea2=me.solidArea.x+size;
            int myYArea2=me.solidArea.y+size;

            int theirXArea1=them.solidArea.x;
            int theirYArea1=them.solidArea.y;
            int theirXArea2=them.solidArea.x+size;
            int theirYArea2=them.solidArea.y+size;

            //System.out.println(solidAreaHeight);
            //System.out.println("Their x: "+theirXArea1+" My x: "+myXArea1);
            //System.out.println("My x1: "+myXArea1+" My y1: "+myYArea1+"\nMy x2: "+myXArea2+" My y2: "+myYArea2+"\n");
            //System.out.println("Their x1: "+theirXArea1+" Their y1: "+theirYArea1+"\nTheir x2: "+theirXArea2+" Their y2: "+theirYArea2);

            //They're Right                 Up                    Left            Down          
            // if (theirXArea1>myXArea1&&theirYArea1<myYArea1&&theirXArea2<myXArea2&&theirYArea2>myYArea2){
            //     //Start Battle
            //     System.out.println("Yep1");
            // } else if (theirXArea2>myXArea1&&theirYArea2<myYArea1&&theirXArea2<myXArea2&&theirYArea2<myYArea2){
            //     //Start Battle
            //     System.out.println("Yep2");
            // }

            if (myXArea1>theirXArea1&&myXArea1<theirXArea2
            &&myYArea1>theirYArea1&&myYArea1<theirYArea2||
            myXArea2>theirXArea1&&myXArea2<theirXArea2
            &&myYArea2>theirYArea1&&myYArea2<theirYArea2||
            myXArea2>theirXArea1&&myXArea2<theirXArea2
            &&myYArea1>theirYArea1&&myYArea1<theirYArea2||
            myXArea1>theirXArea1&&myXArea1<theirXArea2
            &&myYArea2>theirYArea1&&myYArea2<theirYArea2){
                return (true);
                //System.out.println("test");
            } else{
                return (false);
            }
            
        }
        return (false);
    }

    

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        //g2.dispose();
        // int solidAreaWidth=32;
        // int solidAreaHeight=32;
        solidArea=new Rectangle(x,y, size, size);

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