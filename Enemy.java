public class Enemy{
    public String name;
    public int hp;
    public int dp;
    public int mp;

    public Enemy(String myName, int health, int damage, int magic){
        name=myName;
        hp=health;
        dp=damage;
        mp=magic;
    }
    public String getName(){
        return name;
}
    public int getHP(){
        return hp;
}
    public int  getDP(){
        return dp;
}
    public int getMP(){
        return mp;
}
    public void setHP(int health){
         hp= health;
}
    public void setDP(int damage){
        dp= damage;
}
    public void setMP(int magic){
     mp= magic;
}
    public String toString(){
        return name+", Health: "+hp+", damage: "+dp+" magic: "+mp;
}

}
