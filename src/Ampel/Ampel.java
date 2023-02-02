package Ampel;

public class Ampel {
    Boolean red = false;
    public void setRed(){
        red = true;
    }
    public synchronized void setGreen() {
            red = false;
            notify();
            notify();
    }
    public synchronized void pass (){
            while(red){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        try {
            Thread.sleep((int)(Math.random()*500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
