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
    
    public boolean isFalling()
    {
        if(isInAir == true)
        {
            if(y_velocity > 0)  // Der Spieler springt offensichtlich
            {
                return false;
            }
            else    // Nur wenn eine Abwärtsbewegung stattfindet fällt der Spieler tatsächlich
            {
                return true;
            }
        }
        else{ return false; }
    }
    
    public void setFalling()
    {
        isInAir = true;
    }
    
    public void bottomCollisionWithObject(RenderItem i1)
    {
        isInAir = false;            // der Spieler muss zuvor gesprungen sein, also wird dieser Zustand gelöscht
        y_velocity = 0.0f;          // die Gravitation greift nicht wenn der Spieler auf einem Objekt steht
        this.pos_y = i1.pos_y - (this.height);      // der Spieler soll auf dem Objekt stehen
    }
    
    public void update(GameContainer container, int delta)
    {
        switch(player_id)
        {
            case(1):
                   
            // [<-] Links bewegung
            if(container.getInput().isKeyDown(Input.KEY_LEFT)){
               pos_x -= 0.5f * delta;
            }
            // [<-] Rechts bewegung
            if(container.getInput().isKeyDown(Input.KEY_RIGHT)){
                pos_x += 0.5f * delta;
            }
            // [↕] Oben bewegung
            if(container.getInput().isKeyPressed(Input.KEY_UP) && isInAir == false){
                y_velocity = 1.0f * delta;
               isInAir = true;
            }
            
            break;
            case(2):
                   
            // [<-] Links bewegung
            if(container.getInput().isKeyDown(Input.KEY_A)){
               pos_x -= 0.5f * delta;
            }
            // [<-] Rechts bewegung
            if(container.getInput().isKeyDown(Input.KEY_D)){
                pos_x += 0.5f * delta;
            }
            // [↕] Oben bewegung
            if(container.getInput().isKeyPressed(Input.KEY_W) && isInAir == false){
                y_velocity = 1.0f * delta;
               isInAir = true;
            }
            
            break;
        }
        
        if(isInAir == true && y_velocity >= -12.0f)
        {
            y_velocity -= 0.05f * delta;
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
