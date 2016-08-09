package pl.edu.pw.zaremba.tabFileConverter.api;


import pl.edu.pw.zaremba.tabFileConverter.api.EvaluationConfigOption;

/**
 * Interface for strategies which evaluate parsing results.
 * Created by Mateusz on 2016-06-25.
 */
public interface EvaluationStrategy {

    /**
     * Method evaluates parsing result
     *
     * @param goldenFilePath file path to file containing correct parsing result
     * @param resultFilePath file path to file containing parsed result
     * @return evaluation score in percents
     */
    double evaluate(String goldenFilePath, String resultFilePath);

    /**
     * Method loading configuration for strategy
     *
     * @param options to load
     */
    void loadConfiguration(EvaluationConfigOption options);
}
