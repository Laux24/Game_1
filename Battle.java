import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Battle {
    public int uix=0 ;
    public int uiy=0 ;
    Player player;
    Enemy enemy;
    KeyHandler keyH;
    Thread gameThread;
    public Boolean myturn= true;
    
    public Battle(Player play, Enemy enem, KeyHandler keyHa) {
        player= play;
        enemy= enem;
        keyH=keyHa;
    }

    public void chngeUI(ArrayList<JLabel> jls, int n){
        for (int i=0; i<jls.size(); i++){
            jls.get(i).setBackground(Color.DARK_GRAY);
            jls.get(i).setForeground(Color.white);
        }
        JLabel current= jls.get(n);
        current.setBackground(Color.WHITE);
        current.setForeground(Color.BLACK);
    }

    public void sequence(Container glpa, ArrayList<JLabel> jls, Thread gameThread){
        glpa.setVisible(true);
        ArrayList<String> actions= new ArrayList<>();
        actions.add("Attack");
        actions.add("Magic");
        actions.add("Defend");
        actions.add("Flee");
        chngeUI(jls, uix);
        
        
        //System.out.println(uix);

        if ((enemy.hp>0&&player.hp>0)){
            if (myturn){
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

                    chngeUI(jls, uix);
                    
                    
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
                    chngeUI(jls, uix);
                    
                    
                    try {
                        Thread.sleep((long)130);
                        //System.out.println("done");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if (keyH.enterPressed==true){
                    System.out.println( actions.get(uix));
                    //System.out.println("Enemy HP: "+enemy.hp+" Player HP: "+player.hp);
                    
                    if (uix==0){
                        enemy.setHP(enemy.hp-player.dp);
                        System.out.println("Player Damage: "+player.dp);
                        // System.out.println("Enemy Health: "+enemy.getHP());
                    } else if(uix==1){
                        enemy.setHP(enemy.hp-player.mp);
                        System.out.println("Player Magic: "+player.mp);
                        // System.out.println("Enemy Health: "+enemy.getHP());
                    }
                    
                    System.out.println("Enemy HP: "+enemy.hp+" Player HP: "+player.hp);
                    System.out.println();
                    myturn=false;
                    glpa.setVisible(false);
                    try {
                        Thread.sleep((long)500);
                        //System.out.println("done");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    
                }
            } else if(enemy.hp>0){
                Random rand= new Random();
                int i= rand.nextInt(75)+1;

                if (i<=25){
                    player.setHP(player.hp-=enemy.dp);
                    System.out.println("Enemy Damage: "+enemy.dp);
                    //System.out.println(enemy.hp+" "+player.hp);
                    //System.out.println("boom");
                } else if (i<=50){
                    player.setHP(player.hp-=enemy.mp);
                    System.out.println("Enemy Magic: "+enemy.mp);
                    //System.out.println(enemy.hp+" "+player.hp);
                    //System.out.println("bam");
                } else if (i<=75){
                    //divde damage by half
                    System.out.println("Defend");
                }
                System.out.println("Enemy HP: "+enemy.hp+" Player HP: "+player.hp);
                System.out.println();
                myturn=true;
                
            }
        } else if(enemy.hp<=0){
            enemy.bye();
            glpa.setVisible(false);
            System.out.println("Victory!");
        } else{
            player.bye();
            glpa.setVisible(false);
            System.out.println("How Unfortunate");
        }
            
        
    }
}


