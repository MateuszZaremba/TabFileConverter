package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;


import pl.edu.pw.zaremba.tabFileConverter.EvaluationConfigOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Unlabeled Attachment Score - how many words have correct head
 * <p/>
 * Created by Mateusz on 2016-06-25.
 */
public class UAS_Strategy extends EvaluationStrategyBase implements EvaluationStrategy {

    private int headColumnNumber;

    /**
     * @inheritDoc
     */
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
                        correctEvaluations++;
                    }
                    evaluationsMade++;
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

    /**
     * @inheritDoc
     */
    @Override
    public void loadConfiguration(EvaluationConfigOption options) {
        headColumnNumber = options.getHeadPosition();
    }

}
