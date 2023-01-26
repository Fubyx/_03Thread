package Lagerverwaltung;

public class Lieferant extends Thread {
    private Lager l;
    public Lieferant ( Lager l ){
        this.l = l;
    }
    public void anliefern(int anzahl){
        //synchronized( l ) {
            int bestand = l.getBestand();
            System.out.print( getName() + " Bestand alt: " + bestand );
            System.out.println( " Liefermenge: " + anzahl );
            l.setBestand( bestand + anzahl );
        //}
        /*
        while(l.wirdBeliefert);
        l.wirdBeliefert = true;
        int bestand = l.getBestand() ;
        System. out.print (getName () + "Bestand alt: " + bestand ) ;
        System.out.println( "Liefermenge: " + anzahl) ;
        l.setBestand(bestand + anzahl ) ;
        l.wirdBeliefert = false;
        //*/
    }
    public void run(){
        synchronized (l) {
            anliefern(10);
        }
    }
}

/*wenn man den synchronized block nehme, dann wird ja das gesamte Objekt gesperrt, dann ist es teilweise nicht so performant*/
