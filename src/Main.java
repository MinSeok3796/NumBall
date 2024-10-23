import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand  = new Random();

        for(int i = 0; i < 5; i++){
            System.out.println((int)(Math.random() * 10) + 1);
        }
//        rand.setSeed(System.currentTimeMillis());
//        for(int i = 0; i < 5; i++){
//         System.out.println(rand.nextInt(20)+" ");
//        }


    }
}