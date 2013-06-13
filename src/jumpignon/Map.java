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
                
                Image iRect = new Image("resources/rect_01.png");
                Rectangle oRect = new Rectangle(300, 420-75, 75, 75, 0 );
                oRect.setImage(iRect);
                
                Image iRect2 = new Image("resources/rect_01.png");
                Rectangle oRect2 = new Rectangle(500, 420-75, 75, 75, 0 );
                oRect2.setImage(iRect2);
                
                renderlist.addItem(oFloor);
                renderlist.addItem(oRect);
                renderlist.addItem(oRect2);
                
            break;
                  
        }
        
    }
    
    
}
