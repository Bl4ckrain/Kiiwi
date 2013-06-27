
package jumpignon;

import org.newdawn.slick.*;

public abstract class RenderItem {
    
    RenderItem follower = null;
    int z_info = 1;
    Image image;
    float pos_x;
    float pos_y;
    int height;
    int width;
    
    public int get_height(){return height;}
    public int get_width(){return width;}
    public float get_pos_x(){return pos_x;}
    public float get_pos_y(){return pos_y;}
    
    public void setImage(Image a)
    {
        image = a;
    }
    
    public void addFollower(RenderItem a)
    {
        if(this.follower == null)
        {
            follower = a;
        }
        else
        {
            follower.addFollower(a);
        }
    }
    
    // Rendert sich selbst und ruft die Methode beim Nachfolger auf
    public void renderMe(Graphics g) throws SlickException
    {
        g.drawImage(image, pos_x, pos_y);
        
        if(this.follower != null)
        {
            this.follower.renderMe(g);
        }
    }
    
    // Überprüft ob eine Kollision mit einem Player vorliegt und wenn ja was für eine
    public void checkCollision(Player p1)
    {
        float linkerRandObjekt = this.pos_x;
        float rechterRandObjekt = this.pos_x + this.width;
        
        float linkerRandPlayer = p1.pos_x;
        float rechterRandPlayer = p1.pos_x + p1.width;
        
        if(     this.pos_y <= ( p1.get_height() + p1.get_pos_y() )      &&
                this.pos_y >= ( p1.get_height() + p1.get_pos_y() - 25)   &&
                linkerRandObjekt <= rechterRandPlayer                   &&
                rechterRandObjekt >= linkerRandPlayer                   &&
                
                p1.isFalling() == true  ) 
            
        {
            p1.bottomCollisionWithObject(this);
        }
        else if( this.pos_y == ( p1.get_height() + p1.get_pos_y() )      &&          
                (linkerRandObjekt >= rechterRandPlayer                   &&
                linkerRandObjekt <= rechterRandPlayer +7)                ||
                (rechterRandObjekt <= linkerRandPlayer                   &&
                rechterRandObjekt >= linkerRandPlayer -7)                &&
                 p1.isFalling() == false  ) 
        {
            p1.setFalling();
        }
        
        if(this.follower != null)
        {
            this.follower.checkCollision(p1);
        }
    }
    
}