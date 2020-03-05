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
        boolean result = false;
        boolean isone = false;
        boolean isfour = false;
        for (int value : arr) {
            if (value == 1) {
                isone = true;
            }
            if (value == 4) {
                isfour = true;
            }
        }
        result = isfour && isone;
        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[]{
                0, 1, 65, 3, 2, 5, 67, 23, 78, 4, 4, -2
        };
        System.out.println(Arrays.toString(afterFour(array)));

//        int[] array1 = new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] array1 = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4,};
        System.out.println(isOneFour(array1));
    }
}
