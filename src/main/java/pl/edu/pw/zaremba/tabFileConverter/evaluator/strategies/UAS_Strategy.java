package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;

import pl.edu.pw.zaremba.tabFileConverter.evaluator.utils.ConfigOption;

/**
 * Unlabeled Attachment Score - how many words have correct head
 *
 * Created by Mateusz on 2016-06-25.
 */
public class UAS_Strategy implements EvaluationStrategy {

    private int headColumnNumber;

    /**
     * Number of correct parsed words
     */
    private int correctEvaluations;

    /**
     * Number of words evaluated in total
     */
    private int evaluationsMade;

    public UAS_Strategy() {
        correctEvaluations = 0;
        evaluationsMade = 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public double evaluate(String goldenFilePath, String resultFilePath) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void loadConfiguration(ConfigOption options) {

    }


}
