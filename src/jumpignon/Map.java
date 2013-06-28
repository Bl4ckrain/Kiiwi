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
                Rectangle oRect = new Rectangle(300.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect.setImage(iRect);
                
                Image iRect2 = new Image("resources/rect_01.png");
                Rectangle oRect2 = new Rectangle(500.0f, 420.0f-125.0f, 75, 75, 0 );
                oRect2.setImage(iRect2);
                
                Image iRect3 = new Image("resources/rect_01.png");
                Rectangle oRect3 = new Rectangle(700.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect3.setImage(iRect3);
                
                Image iRect4 = new Image("resources/rect_01.png");
                Rectangle oRect4 = new Rectangle(100.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect4.setImage(iRect4);
                
                renderlist.addItem(oFloor);
                renderlist.addItem(oRect);
                renderlist.addItem(oRect2);
                renderlist.addItem(oRect3);
                renderlist.addItem(oRect4);
                
            break;
                  
        }
        
    }
    
    
}
