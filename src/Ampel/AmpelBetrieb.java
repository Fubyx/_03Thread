package Ampel;

public class AmpelBetrieb {
    public static void main(String[] args) {
        Ampel[] ampeln = new Ampel[7];
        Auto[] autos = new Auto[20];
        for (int i = 0; i < ampeln.length; i++)
            ampeln[i] = new Ampel();
        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Auto("Auto " + i, ampeln);
            autos[i].start();
        }

        while (true) {
            for (int i = 0; i < ampeln.length; i = i + 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println("======================================================");
                for (int j = 0; j < ampeln.length; j++) {
                    String prefix;
                    if (j == i || j == i + 1)
                        prefix = "->";
                    else
                        prefix = "  ";
                    System.out.print(prefix + " vor Ampel " + j + ":");
                    for (int k = 0; k < autos.length; k++) {
                        if (autos[k].getPos() == j)
                            System.out.print(" " + k);
                    }
                    System.out.println();
                }

                System.out.println("======================================================");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
                ampeln[i].setGreen();
                if (i + 1 < ampeln.length)
                    ampeln[i + 1].setGreen();
                try {
                    Thread.sleep((int) (Math.random() * 500));
                } catch (InterruptedException e) {}
                ampeln[i].setRed();
                if (i + 1 < ampeln.length)
                    ampeln[i + 1].setRed();
            }
        }


    }
}
