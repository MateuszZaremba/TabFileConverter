package pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mateusz on 2016-06-26.
 */
public class EvaluationStrategyBase {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Number of correct parsed words
     */
    protected int correctEvaluations;

    /**
     * Number of words evaluated in total
     */
    protected int evaluationsMade;

    EvaluationStrategyBase(){
        correctEvaluations = 0;
        evaluationsMade = 0;
    }
}
