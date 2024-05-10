import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
      JLabel label= new JLabel("Fight");
      label.setOpaque(true);
      label.setBackground(Color.DARK_GRAY);
      label.setBounds(10,400,150,100);
      label.setForeground(Color.white);
      label.setFont(new Font("Arial", Font.PLAIN, 14));

      JLabel label2= new JLabel("Magic");
      label2.setOpaque(true);
      label2.setBackground(Color.DARK_GRAY);
      label2.setBounds(210,400,150,100);
      label2.setForeground(Color.white);
      label2.setFont(new Font("Arial", Font.PLAIN, 14));

      JLabel label3= new JLabel("Defend");
      label3.setOpaque(true);
      label3.setBackground(Color.DARK_GRAY);
      label3.setBounds(410,400,150,100);
      label3.setForeground(Color.white);
      label3.setFont(new Font("Arial", Font.PLAIN, 14));

      JLabel label4= new JLabel("Flee");
      label4.setOpaque(true);
      label4.setBackground(Color.DARK_GRAY);
      label4.setBounds(610,400,150,100);
      label4.setForeground(Color.white);
      label4.setFont(new Font("Arial", Font.PLAIN, 14));
      

      ArrayList<JLabel> layers= new ArrayList<JLabel>();
      // JLayeredPane layers= new JLayeredPane();
      // layers.setBounds(0,0,768,576);
      layers.add(label);
      layers.add(label2);
      layers.add(label3);
      layers.add(label4);

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
      for (int i=0; i<layers.size();i++ ){
        glassPane.add(layers.get(i));
      }
      glassPane.setVisible(false);

      

      GamePanel gamePanel=new GamePanel(glassPane, layers);
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