package Homework.Lesson6;

import java.util.Arrays;

public class MainClass {

    static int[] afterFour(int[] arrin) {
        int lastfour = -1;
        for (int i = 0; i < arrin.length; i++) {
            if (arrin[i] == 4) lastfour = i;
        }
        int[] arrout;
        if (lastfour > 0 && lastfour < arrin.length) {
            arrout = new int[arrin.length - lastfour - 1];
            for (int i = lastfour + 1; i < arrin.length; i++) {
                arrout[(i - lastfour - 1)] = arrin[i];
            }
        } else throw new
                RuntimeException();

        return arrout;
    }

    static boolean isOneFour(int[] arr) {
        boolean result;
        boolean isone = false;
        boolean isfour = false;
        for (int value : arr) {
            if (value == 1) {
                isone = true;
            } else
            if (value == 4) {
                isfour = true;
            } else  {isfour = false;
            break;}
        }
        result = isfour && isone;
        return result;
    }
}
