import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
public class GamePanel extends JPanel{
    final int originalTitleSize=16; //16x16
    final int scale= 3;

    final int titleSize= originalTitleSize*scale; //48x48
    final int maxScreenCol= 16;
    final int maxScreenRow= 12;
    final int screenWidth= maxScreenCol*titleSize; //768 pixels
    final int screenHeight= maxScreenRow*titleSize; //576 pixels

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenHeight,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }
}