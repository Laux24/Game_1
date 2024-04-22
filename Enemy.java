import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public String name;
    public int hp;
    public int dp;
    public int mp;

    public Enemy(GamePanel mygp, KeyHandler mykeyH, String myName, int health, int damage, int magic){
        gp=mygp;
        keyH=mykeyH;

        setDefaultVals();
        getEnemyImage();

        //Make sure this isn't the whole sprite, you want to leave a little room
        solidArea=new Rectangle(0,0, 50, 50);
        //You can also do this:
        //solidArea.x / y / height / width = #
        
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
    public void getEnemyImage(){
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
