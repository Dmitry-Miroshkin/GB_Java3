import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FileUtility {
    String pathToResource;


    /*
     * Структура файла ввода: в первой строке одно целое число - N
     * далее следует N целых чисел через пробел
     * Метод должен отсортировать элементы с четным значением,
     * а нечетные оставить на своих местах и вывести результат через пробел в файл вывода
     * Пример:
     * in:
     * 5
     * 5 4 2 1 3    // 2 4
     * out:
     * 5 2 4 1 3
     */
    public void sortEvenElements(File inFile, File outFile) throws IOException {

        Scanner in = new Scanner(inFile);
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            if (in.hasNextInt()) {
                int x = in.nextInt();
                array[i] = x;
            } else
                in.next();
        }

        int[] sorted = sortFiltered(array, (n) -> n % 2 == 0);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(String.valueOf(outFile))));
        for (int i = 0; i < size; ++i) {
            writer.write(String.valueOf(sorted[i]));
            writer.write(" ");
        }

        writer.flush();
    }

    static int[] sortFiltered(int[] src, IntPredicate predicate) {
        int[] filtered = IntStream.of(src).filter(predicate).sorted().toArray();
        int[] dst = new int[src.length];
        for (int i = 0, j = 0; i < src.length; i++) {
            dst[i] = predicate.test(src[i]) ? filtered[j++] : src[i];
        }
        return dst;
    }

    /*
     * Генератор паролей, пароль должен отвечать требованиям:
     * длина не менее 6 и не более 12, включает минимум по одному символу
     * из наборов: a-z, A-Z, 0-9, {*,!,%}
     * все пароли должны быть разными
     * На вход метод получает файл с логинами пользователей
     * Метод должен записать в файл вывода записи с логинами и паролями
     * для каждого пользователя
     */

    public void passwordGen(File in, File out) {
        try {
            FileReader fr = new FileReader(in);
            FileWriter fw = new FileWriter(out);
            BufferedReader reader = new BufferedReader(fr);
            String line1 = reader.readLine();
            while (line1 != null) {

                String password = generateRandomPassword((int) (Math.random() * 13));

                String line = line1 + " " + password + "\n";
                System.out.println("строка: " + line);
                fw.write(line);
                line1 = reader.readLine();
            }
            fr.close();
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String generateRandomPassword(int length) {
        if (length < 4) {
            length = 6;
        }
        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] symbols = "*!%".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789*!%".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length - 4; i++) {
            sb.append(allAllowed[random.nextInt(allAllowed.length)]);
        }

        //Ensure sb policy is met by inserting required random chars in random positions
        sb.insert(random.nextInt(sb.length()), lowercase[random.nextInt(lowercase.length)]);
        sb.insert(random.nextInt(sb.length()), uppercase[random.nextInt(uppercase.length)]);
        sb.insert(random.nextInt(sb.length()), numbers[random.nextInt(numbers.length)]);
        sb.insert(random.nextInt(sb.length()), symbols[random.nextInt(symbols.length)]);
        return sb.toString();
    }


    /*
     *  Метод должен дописать в переданный файл все
     * записи из списка по одной записи в строке
     * */
    public void appender(File file, List<String> records) {

    }

    /*
     * Метод возвращает список из N последних строк файла
     * строки можно дополнять пробелами до длины 80
     * тогда количество символов в файле будет предсказуемо
     * 10 строк это ровно 800 символов
     * Изучите класс RandomAccessFile для эффективного решения данной
     * задачи
     * Альтернативное решение: использование очереди или стека
     * */
    public List<String> getNString(String pathToFile, int n) throws IOException {
        FileReader fr = new FileReader(pathToFile);
        BufferedReader br = new BufferedReader(fr);
        String s = "";

        List<String> tmp = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (s != null) {
            s = br.readLine();
            if (s != null) {
                tmp.add(s);
            }
        }
        fr.close();

        for (int i = tmp.size() - n ; i < tmp.size(); i++) {
            System.out.println(tmp.get(i));
            list.add(tmp.get(i));
        }
        return list;
    }

}
