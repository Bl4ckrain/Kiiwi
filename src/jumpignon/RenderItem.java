
package jumpignon;

import org.newdawn.slick.*;

public abstract class RenderItem {
    
    RenderItem follower = null;
    int z_info = 1;
    Image image = null;
    
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
    
}