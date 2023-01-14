package Tank;

public class Tank {
    private int max ;
    private int inhalt ;
    public Tank( int max ) {
        this. max = max;
    }
    public int getInhalt() {
        return inhalt;
    }
     public synchronized int betanken ( int vol ) {
        int tmp = Math.min( vol, max - inhalt );
        inhalt += tmp;
        return tmp ;
    }
}
