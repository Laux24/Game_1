import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize=16; //16x16
    final int scale= 3;

    final int titleSize= originalTitleSize*scale; //48x48
    final int maxScreenCol= 16;
    final int maxScreenRow= 12;
    final int screenWidth= maxScreenCol*titleSize; //768 pixels
    final int screenHeight= maxScreenRow*titleSize; //576 pixels

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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
            
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(100, 100, 100, 100);
        g2.dispose();
    }
}