import java.awt.Container;

public class Battle {
    int uix=0 ;
    int uiy=0 ;
    Entity player;
    Entity enemy;
    KeyHandler keyH;
    
    public Battle(Container glpa, Entity play, Entity enem, KeyHandler keyHa) {
        glpa.setVisible(true);
        player= play;
        enemy= enem;
        keyH=keyHa;
    }

    public void sequence(){
        //Boolean trfa= true;
        //System.out.println("Xoro");
        if (keyH.upPressed==true){
            System.out.println("up");
        }
        if (keyH.downPressed==true){
            System.out.println("down");
            enemy.x=1000;
        }
        if (keyH.rightPressed==true){
            System.out.println("right");
        }
        if (keyH.leftPressed==true){
            System.out.println("left");
        }
    }
}


