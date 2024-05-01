import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize=16; //16x16
    final int scale= 3;

    final int tileSize= originalTitleSize*scale; //48x48
    final int maxScreenCol= 16;
    final int maxScreenRow= 12;
    final int screenWidth= maxScreenCol*tileSize; //768 pixels
    final int screenHeight= maxScreenRow*tileSize; //576 pixels
    Container glpa;

    int FPS=60;
    public GamePanel(Container glpan){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        glpa= glpan;
        //glpa.setVisible(true);

    }

    //TileManager tileM= new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    ActionBar actionBar=new ActionBar(this);
    public boolean trfa=false;
    // public CollisionChecker cChecker= new CollisionChecker(this);
    public Player blue= new Player(this,keyH, "blue", 100, 10, 20);
    public Enemy red= new Enemy(this, "red", 100, 10, 20);
    public Battle battle= new Battle( blue, red, keyH);
    
    



    

    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        double drawInterval= 1000000000/FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;

        while (gameThread!=null){

            update();
            repaint();

            try {
                double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;
                if (remainingTime<0){
                    remainingTime=0;
                    
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime+=drawInterval;
                //System.out.println("run");
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }

    }

    public void update(){
        if (!(blue.checkEntity(blue, red))){
            blue.update();
            red.setAction();
        }
        
        if (blue.checkEntity(blue, red)){
            // if (!trfa){
                
            //     battle.sequence(glpa);
            //     trfa=true;
            // }
            battle.sequence(glpa, gameThread);
            

            
            //System.out.println(red.x);
        }
        

        
        // collsionOn=false;
        // gp.cChecker.checkTile(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        red.draw(g2);
        blue.draw(g2);
        //tileM.draw(g2);

        
    }
}