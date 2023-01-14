package Testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/fragen.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            for(int i = 0; i < 100; ++i){
                String [] paul = br.readLine().split(";");
                if(paul.length == 11)
                    continue;
                for(String j:paul){
                    //if(i.equals(""))
                        System.out.println(j);
                }
                System.out.println("------------------------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
