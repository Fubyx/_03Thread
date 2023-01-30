package Erzeuger_Verbraucher_Problem;

import java.util.ArrayList;

public class Erzeuger extends Thread{
    ArrayList<String> puffer;
    Integer maxAmt;
    Erzeuger(ArrayList<String> puffer, int maxAmt){
        this.puffer = puffer;
        this.maxAmt = maxAmt;
    }
    @Override
    public void run (){
        while(true) {
            addItem("test");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addItem (String s){
        synchronized (puffer){
            if(puffer.size() < maxAmt) {
                puffer.add(s);
                if(puffer.size() == 1){
                    puffer.notify();
                    System.out.println("TEst");
                }
                System.out.println(s + " wurde hinzugefügt");
            }else{
                try {
                    maxAmt.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
