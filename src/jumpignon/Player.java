package jumpignon;

import org.newdawn.slick.*;

public class Player extends RenderItem{
    
    private int health;
    private int player_id;
    private int kill_score;
    private int death_score;
    private float y_velocity;
    private float x_velocity;
    private boolean isInAir;
    
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
        isInAir = false;
        y_velocity = 0.0f;
        
        this.respawn(h_x, h_y);
    }
    
    public void update(GameContainer container, int delta)
    {
        if( y_velocity > 0 )
        {
            y_velocity -= 0.5f * delta;
        }
        // [<-] Links bewegung
        if(container.getInput().isKeyDown(Input.KEY_LEFT)){
            pos_x -= 1.25f * delta;
        }
        // [<-] Rechts bewegung
        if(container.getInput().isKeyDown(Input.KEY_RIGHT)){
            pos_x += 1.25f * delta;
        }
        // [↕] Oben bewegung
        if(container.getInput().isKeyPressed(Input.KEY_UP)){
            y_velocity += 15.0f * delta;
            isInAir = true;
        }
        
        if(isInAir == true)
        {
            pos_y += 0.5f * delta;
        }
        
        if(pos_y > 420-54)
        {
            isInAir = false;
            y_velocity = 0;   
            pos_y = 420-54;
        }
        
        pos_y -= y_velocity;
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
