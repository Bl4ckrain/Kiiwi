/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpignon;

import org.newdawn.slick.*;

/**
 *
 * @author Max
 */
public class RenderList {
    
    private RenderItem first;
    
    public RenderList()
    {
        first = null;
    }
    
    public void addItem(RenderItem a)
    {
        if(first == null)
        {
            first = a;
        }
        else
        {
            first.addFollower(a);
        }
    }
    
    // Beim Init wird die Liste durchgegangen
    // und anschließend jedes Bild geladen und
    // dessen z_info gesetzt.
    public void init()
    {
        first = null;
    }
    
    public void render(Graphics g) throws SlickException
    {
        if(first != null)
        {
            first.renderMe(g);
        }
    }
    
}
