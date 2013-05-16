/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpignon;

    
/**
 *
 * @author Blackrain
 */
public class Timer {
    boolean running;
    private int time;
    
    public void Reset(){
    this.time = 0;
    this.running = false;
}
    public int get_Time(){
    return this.time;
    }
}

