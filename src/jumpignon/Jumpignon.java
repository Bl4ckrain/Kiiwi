package jumpignon;

import org.newdawn.slick.*;

/**
 *
 * @author Marius Kuchenbecker, Johannes Hitzinger, Max Sommer
 * @date 13.05.2013
 */
public class Jumpignon extends BasicGame {

public RenderList renderlist;
private Map map;
private Player player1;

public Jumpignon() {
//Setzen des Fenstertitels
    super("Jumpignon");
}
public static void main(String[] args) throws SlickException {
AppGameContainer container = new AppGameContainer(new Jumpignon());
    container.setDisplayMode(925, 520, false);
    container.setTargetFrameRate(75);           // Maximale FPS: 75
container.start();
}

@Override
public void init(GameContainer container) throws SlickException {
//Bild logo.png aus dem Verzeichnis restest laden
//    image = new Image("resources/player_healthy.png");
    
    this.renderlist = new RenderList();
    this.map = new Map(renderlist);
    
    map.loadMap(1); // Beispiel Karte, kann später dynamisch jede Karte geladen werden
    
    Image p1I = new Image("resources/player_healthy.png");
    player1 = new Player(1, 430, 420-54);
    player1.setImage(p1I);
    
}

@Override
public void render(GameContainer container, Graphics g) throws SlickException {
//Text und Bild zeichnen
    g.drawString("Jumpignon Test", 100, 100);
//    g.drawImage(image, 300, 300);
    renderlist.render(g);
    player1.renderMe(g);
}

@Override
public void update(GameContainer container, int delta) throws SlickException {

//Auf Eingaben von Spieler 1 reagieren
    player1.update(container, delta);
    
//Kollisionen prüfen
    renderlist.checkCollisions(player1);
    
//WENN [ESC] -> Spiel beenden.
    if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
        container.exit();
    }
}


}
