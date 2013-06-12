
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
    
}