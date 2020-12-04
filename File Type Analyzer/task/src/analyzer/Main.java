package analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String folderPath = args[0];
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        String patternDBName = args[1];
        System.out.println(folderPath);
        System.out.println(patternDBName);
        FileHandler fileHandler = new FileHandler();
        String s = fileHandler.load(patternDBName);
        Map<String,String> map = fileHandler.getMapOfPatterns(s);

        Worker worker = new Worker();

        for (File f : listOfFiles) {
            String answer = worker.work(map, f.getName(), f.getAbsolutePath());
            System.out.println(answer);
        }
    }
}

/*
 byte[] allBytes = Files.readAllBytes(Paths.get(args[1]));

       System.out.println(pattern);
        System.out.println(algorithm);
        System.out.println(fileType);
byte[] patternInBytes = pattern.getBytes();
    Searcher searcher = new Searcher();
    long startTime = System.nanoTime();
        switch (algorithm) {
                case "--naive":
                System.out.println("naiv");
                if (searcher.searchNaive(allBytes, patternInBytes)) {
                System.out.println(fileType);
                } else {
                System.out.println("Unknown file type");
                }
                break;
                case "--KMP":
                if (searcher.kmpSearch(allBytes, patternInBytes)) {
                System.out.println(fileType);
                } else {
                System.out.println("Unknown file type");
                }
                break;
                }
                long endTime = System.nanoTime();
                System.out.println("It took " + ((double)(endTime - startTime) / 1000000000) + " seconds");
 */

/*
String pattern = args[1];
        String fileType = args[2];
        String folderPath = args[0];

        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        ExecutorService executor = Executors.newCachedThreadPool();
        byte[] patternInBytes = pattern.getBytes();
        List<Callable<String>> list = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                byte[] text = Files.readAllBytes(file.toPath());
                Callable c = new CallableSearcher(patternInBytes, text, file.getName(), fileType);
                //Future<String> future = executor.submit(c);
                list.add(c);
            }
        }
        List<Future<String>> listFutures = executor.invokeAll(list);
        for(Future<String> fut : listFutures){
            try {
                // печатаем в консоль возвращенное значение Future
                // будет задержка в 1 секунду, потому что Future.get()
                // ждет пока таск закончит выполнени
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
 */