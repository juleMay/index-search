package Utils;

public class Stopwatch {

	private long start;
    private long end;
	
    public Stopwatch() {
    	this.start = 0;
    	this.end = 0;
    }
    
    public void start() {
    	this.start = System.nanoTime();
    }
    
    public void stop() {
    	this.end = System.nanoTime();
    }
    
    public void reset() {
    	this.start = 0;
    	this.end = 0;
    }
    
    public long elapsedTime() {
    	return end - start;
    }
}
