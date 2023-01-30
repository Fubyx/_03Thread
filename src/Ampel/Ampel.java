package Ampel;

public class Ampel {
    Boolean red = false;
    public void setRed(){
        red = true;
    }
    public void setGreen() {
        synchronized (red){
            red.notifyAll();
            red = false;
        }
    }
    public void pass (){
        synchronized (red){
            while(red){
                try {
                    red.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Thread.sleep((int)Math.random()*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
