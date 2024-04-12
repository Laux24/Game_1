import javax.swing.JFrame;
public class Main{
    public static void main(String[] args){
      JFrame window= new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("IRP");

      GamePanel gamePanel=new GamePanel();
      window.add(gamePanel);

      //window.setLoccationRelativeTo(null);
      window.setVisible(true);

      Player blue= new Player("Blue", 100, 10, 10);
      Enemy easy= new Enemy("Skeleton", 100, 5, 5);
      //System.out.println(blue);
      //System.out.println(easy);
    }
  }