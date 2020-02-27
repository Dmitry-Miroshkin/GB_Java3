package Homework.Lesson4;

import java.util.ArrayList;

public class Ex1 {

    //    Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
//            (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
    public static void runTask1() {
        Ex1 task4 = new Ex1();
        PrintLetter plt1 = new PrintLetter(task4, 'A', 'B');
        PrintLetter plt2 = new PrintLetter(task4, 'B', 'C');
        PrintLetter plt3 = new PrintLetter(task4, 'C', 'A');

        try {
            plt1.getThread().join();
            plt2.getThread().join();
            plt3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        runTask1();
    }
}
