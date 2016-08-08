package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;


import pl.edu.pw.zaremba.tabFileConverter.EvaluationConfigOption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Mateusz on 2016-06-26.
 */
public class LEM_strategy extends EvaluationStrategyBase implements EvaluationStrategy {

    private int headColumnNumber;

    private int labelColumnNumber;

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
                    String goldenLabel = extractLabelFromLine(goldenLine);
                    String resultLabel = extractLabelFromLine(resultLine);
                    if (resultHead == goldenHead && resultLabel.equals(goldenLabel)) {
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

    @Override
    public void loadConfiguration(EvaluationConfigOption options) {
        headColumnNumber = options.getHeadPosition();
        labelColumnNumber = options.getLabelPosition();
    }

    private int extractHeadFromLine(String line) {
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        return Integer.valueOf(splittedLine[headColumnNumber - 1]);
    }

    private String extractLabelFromLine(String line) {
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        return splittedLine[labelColumnNumber - 1];
    }
}
