package analyzer;

import java.util.concurrent.Callable;

public class CallableSearcher implements Callable<String> {
    public byte[] pattern;
    public byte[] text;
    public String fileName;
    public String fileType;

    public CallableSearcher(byte[] pattern, byte[] text, String fileName, String fileType) {
        this.pattern = pattern;
        this.text = text;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override
    public String call() throws Exception {
        Searcher searcher = new Searcher();
        if (searcher.kmpSearch(text, pattern)) {
            return fileName + ": " + fileType;
        } else {
            return fileName + ": Unknown file type";
        }
    }
}
