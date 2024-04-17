import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel mygp){
        this.gp =mygp;
        tile= new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].collision=true;
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect(0, 0, gp.tileSize, gp.tileSize);
        g2.dispose();
    }
}