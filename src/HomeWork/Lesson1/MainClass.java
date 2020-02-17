package HomeWork.Lesson1;

public class MainClass {
    public static void main(String[] args) {
        Element[] arr = new Element[10];
        for (Integer i = 0; i < arr.length; i++) {
            arr[i] = new Element();
            arr[i].setElem(i);
            System.out.print(arr[i].getElem() + ", ");
        }
        arr[3].setElem("str");
        ChangeElems(arr, 3, 7);
        System.out.println();
        for (Integer i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getElem() + ", ");
        }


    }

    private static void ChangeElems(Element[] arr, int x, int y) {
        Element temp = new Element();
        temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }
}
