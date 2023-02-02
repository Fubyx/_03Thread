package Uebung;

public class Main {
    public static void main(String[] args) {
        long upperbound = 300000000;
        int amountOfThreads = 4;
        long changing = upperbound;

        CountingThread []c = new CountingThread[amountOfThreads];


        for(int i = 0; i < c.length; ++i){
            c[i]= new CountingThread(changing - upperbound/amountOfThreads + 1, changing);
            changing -= upperbound/amountOfThreads;
        }

        for(int i = 0; i < c.length; ++i){
            c[i].start();
        }

        try {
            for(int i = 0; i < c.length; ++i){
                c[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 0;

        for(int i = 0; i < c.length; ++i){
            result += c[i].result;
        }

        System.out.println(result);
    }
}
