package classwork;

import java.io.File;
import java.io.IOException;

public class FileSystem {

    //if directory -> in if file -> print info
    //parent -> child
    static void dfs(String prefix, File file) {
        if (prefix.length() > 2) return;
        if (file != null) {
            if (file.isFile()) {
                System.out.println(prefix + file);
            } else if (file.isDirectory()) {
                File [] files = file.listFiles();
                if (files == null) return;
                for (File f : files) {
                    dfs(prefix + '-', f);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("java3_gb.txt");
        System.out.println(f.getAbsolutePath());
        f.createNewFile();
        System.out.println(f.exists());
        File file = new File("C:\\Users\\Mikhail\\IdeaProjects\\Java31");
        while (file != null) {
            System.out.println(file);
            file = file.getParentFile();
        }
        System.out.println(new File("E:\\").getParent());
        dfs("", new File("E:\\"));
        //System.out.println(file.exists());
        //System.out.println(file.isDirectory());
    }
}
