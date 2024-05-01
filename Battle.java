import java.awt.Container;
import java.util.ArrayList;

public class Battle {
    public int uix=0 ;
    public int uiy=0 ;
    Player player;
    Enemy enemy;
    KeyHandler keyH;
    Thread gameThread;
    
    public Battle(Player play, Enemy enem, KeyHandler keyHa) {
        player= play;
        enemy= enem;
        keyH=keyHa;
    }

    public void sequence(Container glpa, Thread gameThread){
        glpa.setVisible(true);
        ArrayList<String> actions= new ArrayList<>();
        actions.add("Attack");
        actions.add("Magic");
        actions.add("Defend");
        actions.add("Flee");
        //Boolean trfa= true;
        //System.out.println(uix);
        if (keyH.upPressed==true){
            //System.out.println("up");
            uiy+=1;
            
            try {
                Thread.sleep((long)130);
                //System.out.println("done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        if (keyH.downPressed==true){
            //System.out.println("down");
            //enemy.bye();
            uiy-=1;
            
            try {
                Thread.sleep((long)130);
                //System.out.println("done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (keyH.rightPressed==true){
            //System.out.println("right");
            uix+=1;
            if (uix>=actions.size()){
                uix=0;
            }
            System.out.println("uix: "+uix+", action: "+actions.get(uix));
            
            try {
                Thread.sleep((long)130);
                //System.out.println("done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (keyH.leftPressed==true){
            //System.out.println("left");
            uix-=1;
            if (uix<0){
                uix=actions.size()-1;
            }
            System.out.println("uix: "+uix+", action: "+actions.get(uix));
            
            try {
                Thread.sleep((long)130);
                //System.out.println("done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (keyH.enterPressed==true){
            System.out.println( actions.get(uix));
            System.out.println(enemy.hp+" "+player.hp);
            if (uix==0){
                enemy.setHP(enemy.hp-player.dp);
                System.out.println(enemy.getHP());
            }

            
            try {
                Thread.sleep((long)130);
                //System.out.println("done");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
}


