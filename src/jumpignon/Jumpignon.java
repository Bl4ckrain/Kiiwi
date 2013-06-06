package jumpignon;

import org.newdawn.slick.*;

/**
 *
 * @author Marius Kuchenbecker, Johannes Hitzinger, Max Sommer
 * @date 13.05.2013
 */
public class Jumpignon extends BasicGame {

private RenderList renderlist;
private Image image;
public Jumpignon() {
//Setzen des Fenstertitels
super("Jumpignon");
}
public static void main(String[] args) throws SlickException {
AppGameContainer container = new AppGameContainer(new Jumpignon());
    container.setDisplayMode(925, 520, false);
container.start();
}

@Override
public void init(GameContainer container) throws SlickException {
//Bild logo.png aus dem Verzeichnis restest laden
    image = new Image("resources/player_healthy.png");
    
}

@Override
public void render(GameContainer container, Graphics g) throws SlickException {
//Text und Bild zeichnen
    g.drawString("Jumpignon Test", 100, 100);
    g.drawImage(image, 300, 300);
}

@Override
public void update(GameContainer container, int delta) throws SlickException {
//Animation: Bild rotieren
    image.rotate(0.05f);
//Tastenabfrage: Mit Esc-Taste das Spiel beenden
    if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
        container.exit();
    }
}


}
