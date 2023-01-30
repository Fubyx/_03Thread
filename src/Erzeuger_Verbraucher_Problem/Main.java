package Erzeuger_Verbraucher_Problem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> puffer = new ArrayList<>();
        puffer.add("first");
        Integer i = 20;
        Erzeuger e = new Erzeuger(puffer, i);
        Verbraucher v = new Verbraucher(puffer, i);
        Erzeuger e2 = new Erzeuger(puffer, i);
        Verbraucher v2 = new Verbraucher(puffer, i);
        Erzeuger e3 = new Erzeuger(puffer, i);
        Verbraucher v3 = new Verbraucher(puffer, i);


        e.start();
        v.start();
        e2.start();
        v2.start();
        e3.start();
        v3.start();

        try {
            e.join();
            v.join();
            e2.join();
            v2.join();
            e3.join();
            v3.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
