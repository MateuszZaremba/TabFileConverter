package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;

import pl.edu.pw.zaremba.tabFileConverter.evaluator.utils.ConfigOption;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Labeled Atachment Score - how many words have correct head and label
 * <p/>
 * Created by Mateusz on 2016-06-26.
 */
public class LAS_Strategy extends EvaluationStrategyBase implements EvaluationStrategy {

    private int headColumnNumber;

    private int labelColumnNumber;

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
                    if (resultHead == goldenHead && goldenLabel.equals(resultLabel)) {
                        correctEvaluations++;
                    }
                    evaluationsMade++;
                } else {
                    System.out.println("linia");
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

    private String extractLabelFromLine(String line) {
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        return splittedLine[labelColumnNumber - 1];
    }

    @Override
    public void loadConfiguration(ConfigOption options) {
        headColumnNumber = options.getHeadPosition();
        labelColumnNumber = options.getLabelPosition();
    }
}
