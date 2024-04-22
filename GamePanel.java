import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize=16; //16x16
    final int scale= 3;

    final int tileSize= originalTitleSize*scale; //48x48
    final int maxScreenCol= 16;
    final int maxScreenRow= 12;
    final int screenWidth= maxScreenCol*tileSize; //768 pixels
    final int screenHeight= maxScreenRow*tileSize; //576 pixels

    int FPS=60;

    TileManager tileM= new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    Player blue= new Player(this,keyH, "blue", 1, 2, 3);

    // int playerX= 100;
    // int playerY= 100;
    // int playerSpd= 4;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        double drawInterval= 1000000000/FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;

        while (gameThread!=null){
            // long currentTime=System.nanoTime();
            // System.out.println("Le time: "+currentTime);

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
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }

    }

    public void update(){
        
        blue.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        blue.draw(g2);
        tileM.draw(g2);

        // g2.setColor(Color.white);
        // g2.fillRect(playerX, playerY, tileSize, tileSize);
        // g2.dispose();
        
    }
}