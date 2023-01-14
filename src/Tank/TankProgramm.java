package Tank;

public class TankProgramm {

    static final int LEN = 10;
    public static void main( String [ ] args ) {
        StopWatch uhr = new StopWatch();
        uhr.start();
        Tank t = new Tank(10000000);
        Pumpe[ ] p = new Pumpe[10];
        for( int i=0; i<LEN; i++ )
            p[i] = new Pumpe( "Pumpe-" + i, t, 1);

        for( int i=0; i<LEN; i++ )
            p[i].start();
        try {
            for( int i=0; i<LEN; i++ )
                p[i].join();
        } catch(InterruptedException e) {}
        uhr.stop();

        int sum = 0;
        for( int i=0; i<LEN; i++ )
            sum += p[i].getSum();

        System.out.println("Inhalt: " + t.getInhalt() + "=" + sum);
        System.out.println("Zeit: " + uhr.getElapsedTime() + "ms");
        /*
        Pumpe p1 = new Pumpe(" Pumpe-1", t, 1);
        Pumpe p2 = new Pumpe(" Pumpe-2", t, 2);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch(InterruptedException e) {}
        uhr.stop();
        System.out.println("Inhalt: " + t.getInhalt() + "=" + (p1.getSum() + p2.getSum()));
        System.out.println("Zeit: " + uhr.getElapsedTime() + "ms");
        */

    }
}