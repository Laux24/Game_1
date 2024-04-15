import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize=16; //16x16
    final int scale= 3;

    final int tileSize= originalTitleSize*scale; //48x48
    final int maxScreenCol= 16;
    final int maxScreenRow= 12;
    final int screenWidth= maxScreenCol*tileSize; //768 pixels
    final int screenHeight= maxScreenRow*tileSize; //576 pixels

    KeyHandler keyH= new KeyHandler();
    Thread gameThread;

    int playerX= 100;
    int playerY= 100;
    int playerSpd= 4;


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
        while (gameThread!=null){
            update();
            repaint();

        }

    }

    public void update(){
        if (keyH.upPressed==true){
            
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}