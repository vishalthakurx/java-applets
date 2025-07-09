/*
 * MultithreadedFileSearcher.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: Searches for a keyword in files using Java threads and concurrency utilities.
 */
import java.io.*;
import java.util.concurrent.*;

public class MultithreadedFileSearcher {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            System.out.println("Usage: java MultithreadedFileSearcher <dir> <keyword>");
            return;
        }
        ExecutorService pool = Executors.newFixedThreadPool(4);
        searchDir(new File(args[0]), args[1], pool);
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
    static void searchDir(File dir, String keyword, ExecutorService pool) {
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) searchDir(f, keyword, pool);
            else pool.submit(() -> searchFile(f, keyword));
        }
    }
    static void searchFile(File file, String keyword) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line; int n = 1;
            while ((line = br.readLine()) != null) {
                if (line.contains(keyword))
                    System.out.printf("%s:%d: %s\n", file.getPath(), n, line);
                n++;
            }
        } catch (IOException e) {}
    }
}
