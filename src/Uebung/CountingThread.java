package Uebung;

public class CountingThread extends Thread{
    long result = 0, lowerBound, upperBound;

    CountingThread(long lowerBound, long upperBound){
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
    @Override
    public void run (){
        for(long i = lowerBound; i <= upperBound; ++i){
            result += i;
        }
    }
}
