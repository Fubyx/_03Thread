package Parkhaus;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        Parkhaus p = new Parkhaus(5);
        Auto[] autos = new Auto[size];
        for(int i = 0; i < size; ++i){
            autos[i] = new Auto(p);
        }
        for(int i = 0; i < size; ++i){
            autos[i].start();
        }
        for(int i = 0; i < size; ++i){
            try {
                autos[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
