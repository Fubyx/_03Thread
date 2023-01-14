package Lagerverwaltung;

public class Lagerverwaltung {
    public static void main( String[] args ){
        Lager myLager = new Lager();
        Lieferant l1 = new Lieferant( myLager );
        Lieferant l2 = new Lieferant( myLager ) ;
        l1.start() ; //Lieferung kann erfolgen!
        l2.start() ; //
        try { //warten, bis alle geliefert haben

            l1.join();
            l2.join();

        }catch(InterruptedException e){e.printStackTrace();}
        System.out.println("Endbestand : " + myLager.getBestand());
    }
}