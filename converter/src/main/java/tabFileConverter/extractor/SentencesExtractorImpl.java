package tabFileConverter.extractor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Mateusz on 2016-06-27.
 */
public class SentencesExtractorImpl implements SentenceExtractor {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void extractSentences(String sourcePath, String resultFileName, int wordLineNumber) {
        try (BufferedReader brGolden = new BufferedReader(new FileReader(sourcePath))) {
            FileOutputStream fos1 = new FileOutputStream("SENTENCES_File", true);
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
            boolean firstWord = true;
            while (brGolden.ready()) {
                String line = brGolden.readLine();
                if (!line.equals("")) {
                    if(!firstWord){
                        bw1.write(" ");
                        firstWord = false;
                    }
                    String word = extractWordFromLine(line, wordLineNumber);
                    bw1.write(word);
                } else {
                    bw1.newLine();
                    firstWord = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("EXTRACTED SENTENCES INTO : {}", resultFileName);
    }

    private String extractWordFromLine(String line, int wordLineNumber) {
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        return splittedLine[wordLineNumber - 1];
    }

    public static void main(String[] args) {
        SentencesExtractorImpl se = new SentencesExtractorImpl();
        se.extractSentences("CLEAR_NLP_TEST_FILE", "SENTENCES", 2);
    }

}
