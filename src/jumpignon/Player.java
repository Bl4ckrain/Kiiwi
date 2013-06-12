package jumpignon;

import org.newdawn.slick.*;

public class Player extends RenderItem{
    
    private int health;
    private int player_id;
    private int kill_score;
    private int death_score;
    
    // Infos zum Rendern
    RenderItem follower;
    int z_info;
    private Image image;
    
    
    
    public Player(int h_id, int h_x, int h_y)
    {
        health = 2;
        player_id = h_id;
        kill_score = 0;
        death_score = 0;
        width = 48;
        height = 54;
        
        this.respawn(h_x, h_y);
    }
    
    public void update(GameContainer container, int delta)
    {
        // [<-] Links bewegung
        if(container.getInput().isKeyDown(Input.KEY_LEFT)){
            pos_x -= 0.25f * delta;
        }
    }
    
    public void loseHp()
    {
        health -= 1;
        
        if(health == 0)
        {
            death_score++;
            
        }
    }
    
    public void gainHp()
    {
        if(health != 2)
        {
            health++;
        }
    }
    
    public void respawn(int h_x, int h_y)
    {
        pos_x = h_x;
        pos_y = h_y;
    }
    
}
