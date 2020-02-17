package HomeWork.Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        Element[] arr = new Element[10];
        System.out.println("Исходный массив: ");
        for (Integer i = 0; i < arr.length; i++) {
            arr[i] = new Element();
            arr[i].setElem(i);
        }
        arr[3].setElem("stroka");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getElem() + ", ");
        }
        System.out.println("Массив после замены 4 и 8 элемента: ");
        ChangeElems(arr, 3, 7);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getElem() + ", ");
        }
        System.out.println();
        ArrayList<Element> list = ArrToList(arr);
        System.out.print("выводим ArrayList: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getElem() + ", ");
        }

    }

    private static void ChangeElems(Element[] arr, int x, int y) {
        Element temp = new Element();
        temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }

    private static ArrayList<Element> ArrToList(Element[] arr) {

        int size = arr.length;
        if (arr.getClass() != Element[].class) {
            arr = Arrays.copyOf(arr, size, Element[].class);
        }
        ArrayList<Element> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }
}
