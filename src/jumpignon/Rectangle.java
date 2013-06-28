package jumpignon;

import org.newdawn.slick.*;

public class Rectangle extends RenderItem{
    int rotation;
   
    //
//rotation muss nochmal gedacht werden ;) wegen collisoin
public Rectangle(float gx, float gy, int gwidth ,int  gheight ,int grotation ){
    this.pos_x = gx;
    this.pos_y = gy;
    this.width = gwidth;
    this.height = gheight;
    this.rotation = grotation;
}
}
