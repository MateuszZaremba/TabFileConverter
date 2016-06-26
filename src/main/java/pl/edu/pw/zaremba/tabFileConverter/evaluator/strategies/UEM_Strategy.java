package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;

import pl.edu.pw.zaremba.tabFileConverter.evaluator.utils.ConfigOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Unlabeled exact match score
 * Created by Mateusz on 2016-06-26.
 */
public class UEM_Strategy extends EvaluationStrategyBase implements EvaluationStrategy {

    private int headColumnNumber;

    private boolean sentenceIsCorrect = true;


    @Override
    public double evaluate(String goldenFilePath, String resultFilePath) {
        try (BufferedReader brGolden = new BufferedReader(new FileReader(goldenFilePath));
             BufferedReader brResult = new BufferedReader(new FileReader(resultFilePath))) {
            while (brGolden.ready() && brResult.ready()) {
                String goldenLine = brGolden.readLine();
                String resultLine = brResult.readLine();
                if (!goldenLine.equals("") && !resultLine.equals("")) {
                    int goldenHead = extractHeadFromLine(goldenLine);
                    int resultHead = extractHeadFromLine(resultLine);
                    if (resultHead == goldenHead) {
                    } else {
                        sentenceIsCorrect = false;
                    }
                } else {
                    evaluationsMade++;
                    if (sentenceIsCorrect) correctEvaluations++;
                    sentenceIsCorrect = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("EVALUATIONS MADE  : {}", evaluationsMade);
        log.info("CORRECT HEADS : {}", correctEvaluations);
        return (((double) correctEvaluations / (double) evaluationsMade)) * 100;
    }

    private int extractHeadFromLine(String line) {
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        return Integer.valueOf(splittedLine[headColumnNumber - 1]);
    }

    @Override
    public void loadConfiguration(ConfigOption options) {
        headColumnNumber = options.getHeadPosition();
    }
}
