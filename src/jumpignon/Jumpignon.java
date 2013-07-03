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
private int mapID;
private Player player1;
private Player player2;
private Timer timer;
private boolean tensecs;

public Jumpignon() {
//Setzen des Fenstertitels
    super("Jumpignon");
    mapID = 1;
}
public static void main(String[] args) throws SlickException {
    
    /*
     * Wir benutzen für unser Spiel die extra für Spiele ausgelegte
     * 2D Bibliothek "Slick2D". Die Basis für Spiele dieser Bibliothek
     * ist die Klasse AppGameContainer, die alle wichtigen Methoden bereit
     * stellt, um die Grafikausgabe anzusprechen, Sound zu ermöglichen und 
     * so weiter..
     */
    
AppGameContainer container = new AppGameContainer(new Jumpignon());

    /*
     * setDisplayMode stellt die Auflösung für das Fenster ein und ob dieses
     * im Vollbildschirm gestartet werden soll.
     * 
     * setTargetFrameRate sorgt dafür, dass nicht unendlich oft das Bild neu
     * gezeichnet wird. Wenn ein Rechner besonders schnell ist würde dies 
     * dafür sorgen, dass unnötig Leistung verschwendet wird. Da 75 Frames pro 
     * Sekunde für das Spiel vollkommen ausreichen ist dies der Maximalwert.
     * 
     * setShowFPS sorgt dafür, dass die aktuelle Framerate nicht angezeigt wird.
     */
    container.setDisplayMode(925, 520, false);
    container.setTargetFrameRate(75);           // Maximale FPS: 75
    container.setShowFPS(false);
    container.start();

}

/*
 * init() ist eine Methode von BasicGame und wird ganz am Anfang ein 
 * einziges Mal ausgeführt. Hier wird die Map, also die Karte geladen,
 * auf der sich die Spieler bewegen mitsamt allen Grafiken und Sounds.
 */


@Override
public void init(GameContainer container) throws SlickException {
    
    this.timer = new Timer();
    this.renderlist = new RenderList();
    this.map = new Map(renderlist);
    
    map.loadMap(mapID); // Beispiel Karte, kann später dynamisch jede Karte geladen werden
    
    Image p1I1 = new Image("resources/player1/player_healthy.png");
    Image p1I2 = new Image("resources/player1/player_unhealthy.png");
    Image p1I3 = new Image("resources/player1/player_most_unhealthy.png");
    
    Image p2I1 = new Image("resources/player2/player_healthy.png");
    Image p2I2 = new Image("resources/player2/player_unhealthy.png");
    Image p2I3 = new Image("resources/player2/player_most_unhealthy.png");
    
    player1 = new Player(1, 114, 420-54);
    player2 = new Player(2, 714, 420-54);
    player1.setImage(p1I1, p1I2, p1I3);
    player2.setImage(p2I1, p2I2, p2I3);
    
}

/*
 *  Die Methode render() ist ebenso eine Methode der Klasse BasicGame und wird
 *  jedes Mal beim Durchlaufen der Spielschleife ausgeführt um das Bild neu zu
 *  zeichnen. 
 *  Die Klasse BasicGame führt diese Schleife, die die folgende Logik ausführt:
 *  1. Laden der Ressourcen, wie Grafiken oder Sounds       | hier: init()
 *  2. WÄHREND(ESCPAE WURDE NICHT GEDRÜCKT)
 *      {
 *          2.1 Auf Eingaben des Spielers reagieren         | hier: update()
 *          2.2 Das Bild neu zeichnen und darstellen        | hier: render()
 *      }
 */

@Override
public void render(GameContainer container, Graphics g) throws SlickException {
//Text und Bild zeichnen
    
    map.drawMapBackground(g);
    renderlist.render(g);
    player1.renderMe(g);
    player2.renderMe(g);
    
    
    g.setColor(Color.orange);
    g.drawString("Spieler 1: " + player1.showKills() + " / " + player1.showDeaths(), 25, 440);
    
    g.setColor(Color.blue);
    g.drawString("Spieler 2: " + player2.showKills() + " / " + player2.showDeaths(), 750, 440);
}

/*
 *  Auch update() ist eine Methode von BasicGame, die dafür sorgt die Spiel-
 *  logik voran zu treiben und auf Eingaben des Spielers zu reagieren.
 *  Wird beispielsweise eine Taste gedrückt, so soll sich der Spieler beispiels-
 *  weise bewegen. Außerdem soll überprüft werden ob es eine Kollision gab und 
 *  entsprechend darauf reagiert werden.
 */

@Override
public void update(GameContainer container, int delta) throws SlickException {
    
//Map updaten
    map.update(timer);

//Auf Eingaben von Spielern reagieren
    player1.update(container, delta);
    player2.update(container, delta);
    
//Kollisionen prüfen zwischen den Playern und Objekten
    renderlist.checkCollisions(player1);
    renderlist.checkCollisions(player2);

//Kollisionen prüfen zwischen den Playern
    player1.checkBottomCollisionWithPlayer(player2);
    player2.checkBottomCollisionWithPlayer(player1);
    
//WENN [1] -> Map #1 laden
    if(container.getInput().isKeyPressed(Input.KEY_1)){
        this.mapID = 1;
        this.init(container);
    }
//WENN [2] -> Map #2 laden
    if(container.getInput().isKeyPressed(Input.KEY_2)){
        this.mapID = 2;
        this.init(container);
    }
    
//WENN [R] -> Spiel neustarten.
    if(container.getInput().isKeyPressed(Input.KEY_R)){
        this.init(container);
    }
    
//WENN [ESC] -> Spiel beenden.
    if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
        container.exit();
    }
}


}
