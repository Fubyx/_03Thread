package Erzeuger_Verbraucher_Problem;

import java.util.ArrayList;

public class Verbraucher extends Thread{
    ArrayList<String> puffer;
    Integer maxAmt;
    Verbraucher(ArrayList<String> puffer, int maxAmt){
        this.puffer = puffer;
        this.maxAmt = maxAmt;
    }

    @Override
    public void run (){
        while(true){
            removeItem();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeItem (){
        synchronized (puffer){
            String s;
            if(puffer.size() > 0) {
                s = puffer.remove(0);
                if(puffer.size() == maxAmt - 1){
                    maxAmt.notify();

                    System.out.println("TsEt");
                }
                System.out.println(s + " wurde Entfernt");
            }else{
                try {
                    puffer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
