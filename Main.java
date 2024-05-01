import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
public class Main{
    public static void main(String[] args){
      // JLabel label= new JLabel("Hey");
      // label.setOpaque(true);
      // label.setBackground(Color.white);
      // label.setBounds(0,370,768,200);

      // JLayeredPane layers= new JLayeredPane();
      // layers.setBounds(0,0,768,576);
      // layers.add(label);

      JFrame window= new JFrame();
      // window.add(layers);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(true);
      window.setTitle("IRP");
      window.setGlassPane (new JComponent() {
        @Override
        protected void paintComponent(Graphics g){
          g.setColor(Color.gray);
          g.fillRect(0,370,768,200);
        }
      });

      Container glassPane=(Container)window.getGlassPane();
      glassPane.setVisible(false);

      

      GamePanel gamePanel=new GamePanel(glassPane);
      // ActionBar actionBar=new ActionBar(gamePanel);
      window.add(gamePanel);
      // window.getContentPane().add(actionBar);
      //window.add(actionBar);
    


      window.pack();

      //window.setLoccationRelativeTo(null);
      window.setVisible(true);
      gamePanel.startGameThread();

      
      

    }
  }