package jumpignon;

public class Timer {
    boolean running;
    private long starttime;
    private long time;
    
    public Timer()
    {
        starttime = System.currentTimeMillis();
    }
    
    public void Reset(){
    this.starttime = 0;
    this.running = false;
}
    public long getTime(){
    return System.currentTimeMillis();
    }
    public long getStartTime()
    {
        return starttime;
    }
}

