package jumpignon;

public class DeadlyRectangle extends RenderItem
{
    int rotation;
   
    //
//rotation muss nochmal gedacht werden ;) wegen collisoin
public DeadlyRectangle(float gx, float gy, int gwidth ,int  gheight ,int grotation ){
    this.pos_x = gx;
    this.pos_y = gy;
    this.width = gwidth;
    this.height = gheight;
    this.rotation = grotation;
}
    
    public void checkCollision(Player p1)
    {
        float linkerRandObjekt = this.pos_x;
        float rechterRandObjekt = this.pos_x + this.width;
        
        float linkerRandPlayer = p1.pos_x;
        float rechterRandPlayer = p1.pos_x + p1.width;
        
        // Player kommt von Oben und kollidiert mit DeadlyRectangle?
        if(     this.pos_y <= ( p1.get_height() + p1.get_pos_y() )      &&
                this.pos_y >= ( p1.get_height() + p1.get_pos_y() - 25)   &&
                linkerRandObjekt <= rechterRandPlayer                   &&
                rechterRandObjekt >= linkerRandPlayer                   &&
                
                p1.isFalling() == true  ) 
            
        {
            p1.die();
        }
        
        if(this.follower != null)
        {
            this.follower.checkCollision(p1);
        }
    }
    
}
