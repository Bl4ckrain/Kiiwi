package jumpignon;

import org.newdawn.slick.*;

/**
 *
 * @author Marius Kuchenbecker, Johannes Hitzinger, Max Sommer
 * @class Q11/inf
 * @date 13.05.2013
 */
public class Jumpignon extends BasicGame {

public RenderList renderlist;
private Map map;
private Player player1;
private Player player2;

public Jumpignon() {
//Setzen des Fenstertitels
    super("Jumpignon");
}
public static void main(String[] args) throws SlickException {
AppGameContainer container = new AppGameContainer(new Jumpignon());
    container.setDisplayMode(925, 520, false);
    container.setTargetFrameRate(75);           // Maximale FPS: 75
    container.setShowFPS(false);
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
    Image p2I = new Image("resources/player_unhealthy.png");
    player1 = new Player(1, 114, 420-54);
    player2 = new Player(2, 714, 420-54);
    player1.setImage(p1I, p2I);
    player2.setImage(p1I, p2I);
    
}

@Override
public void render(GameContainer container, Graphics g) throws SlickException {
//Text und Bild zeichnen
    g.drawString("Jumpignon Multiplayer Alpha", 25, 25);
    renderlist.render(g);
    player1.renderMe(g);
    player2.renderMe(g);
    g.drawString("Spieler 1: " + player1.showKills() + " / " + player1.showDeaths(), 25, 440);
    g.drawString("Spieler 2: " + player2.showKills() + " / " + player2.showDeaths(), 750, 440);
}

@Override
public void update(GameContainer container, int delta) throws SlickException {

//Auf Eingaben von Spielern reagieren
    player1.update(container, delta);
    player2.update(container, delta);
    
//Kollisionen prüfen zwischen den Playern und Objekten
    renderlist.checkCollisions(player1);
    renderlist.checkCollisions(player2);

//Kollisionen prüfen zwischen den Playern
    player1.checkBottomCollisionWithPlayer(player2);
    player2.checkBottomCollisionWithPlayer(player1);
    
//WENN [ESC] -> Spiel beenden.
    if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
        container.exit();
    }
}


}
