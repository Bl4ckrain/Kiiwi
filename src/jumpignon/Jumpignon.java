package jumpignon;

import org.newdawn.slick.*;

/**
 *
 * @author Marius Kuchenbecker, Johannes Hitzinger, Max Sommer
 * @date 13.05.2013
 */
public class Jumpignon extends BasicGame {

public RenderList renderlist;
private Image image;
private Map map;
public Jumpignon() {
//Setzen des Fenstertitels
    super("Jumpignon");
    this.renderlist = new RenderList();
    this.map = new Map(renderlist);
}
public static void main(String[] args) throws SlickException {
AppGameContainer container = new AppGameContainer(new Jumpignon());
    container.setDisplayMode(925, 520, false);
container.start();
}

@Override
public void init(GameContainer container) throws SlickException {
//Bild logo.png aus dem Verzeichnis restest laden
//    image = new Image("resources/player_healthy.png");
    
    map.loadMap(1);
    
}

@Override
public void render(GameContainer container, Graphics g) throws SlickException {
//Text und Bild zeichnen
    g.drawString("Jumpignon Test", 100, 100);
//    g.drawImage(image, 300, 300);
    renderlist.render(g);
}

@Override
public void update(GameContainer container, int delta) throws SlickException {
//Animation: Bild rotieren
//    image.rotate(0.05f);
//Tastenabfrage: Mit Esc-Taste das Spiel beenden
    if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
        container.exit();
    }
}


}
