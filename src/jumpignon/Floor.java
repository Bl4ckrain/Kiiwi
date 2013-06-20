package jumpignon;

import org.newdawn.slick.*;

public class Floor extends RenderItem {
    private Image image;
    private int height;
    
    public Floor(int b)
    {
        this.height = b;
        this.pos_x = 0.0f;
        this.pos_y = 420.0f;
        this.width = 925;
    }
    
    
    
}
