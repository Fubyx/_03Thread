package Parkhaus;

import java.util.Random;

public class Auto extends Thread{
    Parkhaus p;

    Auto(Parkhaus p){
        this.p = p;
    }


    @Override
    public void run (){
        do{
            driveAround();
            if(p.park()){
                break;
            }
            try {
                sleep(new Random().nextInt(1, 5) * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(!p.park());
        try {
            sleep(new Random().nextInt(1, 10) * 10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        p.leave();
    }

    private void driveAround(){
        Random rand = new Random();
        while(rand.nextInt(100) != 13){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
