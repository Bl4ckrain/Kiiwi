package jumpignon;

import org.newdawn.slick.*;

/*
 * Die Klasse Map ist dafür da alle Objekte die in einer Karte platziert
 * werden zu laden. Dabei können dynamisch mithilfe des Codes neue Karten
 * hinzugefügt werden. Beispiele dafür finden sich weiter unten.
 */

public class Map {
    
    private Image background;
    private RenderList renderlist;
    private int mapID;
    
    /*
     * Im Konstruktor wird der Map die renderlist aus der Hauptklasse Jumpignon
     * übergeben, damit diese mit den Objekten der ausgewählten Map gefüllt 
     * werden kann.
    */
    public Map(RenderList nRenderlist)
    {
        renderlist = nRenderlist;
    }
    
    // Hier wird der Hintergrund gezeichnet.
    public void drawMapBackground(Graphics g)
    {
        g.drawImage(background, 0, 0);
    }
    
    // Alle Objekte der ausgewählten Map wird in die Renderlist geladen
    public void loadMap(int mapid) throws SlickException
    {
        this.mapID = mapid;
        switch(mapid)
        {
            case(1):
                
                // Resources laden
                background = new Image("resources/map1/background.png");
                Image iRect = new Image("resources/map1/rect_01.png");
                Image iRect2 = new Image("resources/map1/rect_02.png");               
                Image iFloor = new Image("resources/map1/floor_01.png");
                
                
                // Objekte in die Map setzen
                Floor oFloor = new Floor(100);
                oFloor.setImage(iFloor);                
                Rectangle oRect = new Rectangle(100.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect.setImage(iRect);                
                Rectangle oRect2 = new Rectangle(300.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect2.setImage(iRect);                
                Rectangle oRect3 = new Rectangle(500.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect3.setImage(iRect);                
                Rectangle oRect4 = new Rectangle(700.0f, 420.0f-75.0f, 75, 75, 0 );
                oRect4.setImage(iRect);                
                Rectangle oRect5 = new Rectangle(150.0f, 420.0f-200.0f, 150, 75, 0 );
                oRect5.setImage(iRect2);                
                Rectangle oRect6 = new Rectangle(450.0f, 420.0f-200.0f, 150, 75, 0 );
                oRect6.setImage(iRect2);                
                DeadlyRectangle oRect7 = new DeadlyRectangle(925.0f, 420.0f, 350, 75, 0 );
                oRect7.setImage(iRect2);                
                DeadlyRectangle oRect8 = new DeadlyRectangle(-350.0f, 420.0f, 350, 75, 0 );
                oRect8.setImage(iRect2);
                
                
                // Objekte in die RenderList mitaufnehmen
                renderlist.addItem(oFloor);
                renderlist.addItem(oRect);
                renderlist.addItem(oRect2);
                renderlist.addItem(oRect3);
                renderlist.addItem(oRect4);
                renderlist.addItem(oRect5);
                renderlist.addItem(oRect6);
                renderlist.addItem(oRect7);
                renderlist.addItem(oRect8);
                
            break;
                  
        }
        
    }
    
    /* 
     * Geplante Funktion für die Zukunft bei der sich eine Map weiter
     * verändern kann nach einer gewissen Zeit oder aufgrund von Spieler-
     * einwirkung.
    */
    public void update(Timer timer)
    {
        switch(mapID)
        {
            
            case(1):
                
                
                
            break;
            
        }        
    }
}
