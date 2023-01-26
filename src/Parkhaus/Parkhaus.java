package Parkhaus;

public class Parkhaus {
    protected int freeSpaces;

    Parkhaus(int freeSpaces){
        this.freeSpaces = freeSpaces;
    }
    public synchronized boolean park (Auto a){
        if(freeSpaces > 0){
            --freeSpaces;
            System.out.println("Auto geparkt " + freeSpaces + "übrig");
            return true;
        }else{
            System.out.println("Voll");
            return false;
        }

    }

    public void leave (){
        ++freeSpaces;
        System.out.println("Auto ausgeparkt " + freeSpaces + "übrig");
    }
}
