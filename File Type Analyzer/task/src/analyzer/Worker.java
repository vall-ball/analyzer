package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Worker {

    public String work(Map<String, String> map, String fileName, String absolutePath) throws IOException {
        Searcher searcher = new Searcher();
        byte[] text = Files.readAllBytes(Paths.get(absolutePath));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("pattern = " + entry.getKey());
            byte[] patternInBytes = entry.getKey().getBytes();
           // if (searcher.kmpSearch(text, patternInBytes)) {
            if (searcher.rabinKarp(text, patternInBytes)) {
                return fileName + ": " + entry.getValue();
            }
        }
        return fileName + ": Unknown file type";
    }
}
