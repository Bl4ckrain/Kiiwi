package jumpignon;

import org.newdawn.slick.*;

public class Player implements RenderItem{
    
    private int health;
    private int position_x;
    private int position_y;
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
        
        this.respawn(h_x, h_y);
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
        position_x = h_x;
        position_y = h_y;
    }
    
    
}
