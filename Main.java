import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Main{
    public static void main(String[] args){
      JFrame window= new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(true);
      window.setTitle("IRP");

      GamePanel gamePanel=new GamePanel();
      window.add(gamePanel);

      window.pack();

      //window.setLoccationRelativeTo(null);
      window.setVisible(true);
      gamePanel.startGameThread();

      
      

      //System.out.println(blue);
      //System.out.println(easy);
    }
  }