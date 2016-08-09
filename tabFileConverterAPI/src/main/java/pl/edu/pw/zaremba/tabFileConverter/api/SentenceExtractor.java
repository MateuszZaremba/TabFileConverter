package pl.edu.pw.zaremba.tabFileConverter.api;

/**
 * Created by Mateusz on 2016-06-27.
 */
public interface SentenceExtractor {

    void extractSentences(String sourcePath, String resultFileName, int wordLineNumber);

}
