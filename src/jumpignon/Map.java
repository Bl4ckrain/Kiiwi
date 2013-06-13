package jumpignon;

import org.newdawn.slick.*;

public class Map {
    
    private Image background;
    private RenderList renderlist;
    
    public Map(RenderList nRenderlist)
    {
        renderlist = nRenderlist;
    }
    
    public void loadMap(int mapname) throws SlickException
    {
        switch(mapname)
        {
            case(1):
               
                Image iFloor = new Image("resources/floor_01.png");
                Floor oFloor = new Floor(100);
                oFloor.setImage(iFloor);
                
                renderlist.addItem(oFloor);
                
            break;
                  
        }
        
    }
    
    
}
