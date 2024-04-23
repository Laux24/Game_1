public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(){
        this.gp=gp;

    }

    public void checkTile(Entity entity) {
        int entityLeft=entity.x + entity.solidArea.x;
        int entityRight=entity.x + entity.solidArea.x + entity.solidAre.width;
        int entityTop= entity.x + entity.solidArea.y;
        int entityBottemo= entity.y + entity.solidArea.y + solidArea.height;

        int enetityLeftCol= entityLeft/gp.tileSize;
        int enetityRightCol= entityRight/gp.tileSize;
        int entityTopRow= entityTop/gp.tileSize;
        int entityBottemRow= entityBottem/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
        case "up":
            entityTopRow=(entityTop-entity.speed)/gp.originalTitleSize;
            break;
        case "down":
            break;
        case "right":
            break;
        case "left":
            break;
        }
    }   

    public int checkEntity(Entity me, Entity them){
        int index=999;
        // if (this.getClass() instanceOf Enemy)
        if (them!=null){
            int myXArea1=me.solidArea.x;
            int myYArea1=me.solidArea.y;
            int myXArea2=me.solidArea.x+me.width;
            int myYArea2=me.solidArea.y+me.height;

            int theirXArea1=them.solidArea.x;
            int theirYArea1=them.solidArea.y;
            int theirXArea2=them.solidArea.x+them.width;
            int theirYArea2=them.solidArea.y+them.height;

            if (theirXArea1>myXArea1&&theirYArea1<myYArea1&&theirXArea1<myXArea2&&theirYArea1<myYArea2){
                //Start Battle
            } else if (theirXArea2>myXArea1&&theirYArea2<myYArea1&&theirXArea2<myXArea2&&theirYArea2<myYArea2){
                //Start Battle
            }
        }
    }
}