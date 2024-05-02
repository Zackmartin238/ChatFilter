package me.zackmartin238.chatrepair;
import java.util.Random;

public class RandomMessage {
    public static String one = "Buddy Holly is my favorite song";
    public static String two = "I tried to say a forbidden word";

    public static String getRandomMessage() {
        Random rand = new Random();
        int m = rand.nextInt(2);
        if (m == 0){
            return one;
        }
        else {
            return two;
        }
    }



}
