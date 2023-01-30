package Ampel;

public class Auto extends Thread{
    Ampel[] ampeln;
    int pos = 0;
    Auto(String name, Ampel[] ampeln){
        this.ampeln = ampeln;
    }

    @Override
    public void run(){
        while (true){
            pos = 0;
            for(Ampel i:ampeln){
                i.pass();
                pos++;
            }
        }
    }

    public int getPos(){
        return pos;
    }
}
