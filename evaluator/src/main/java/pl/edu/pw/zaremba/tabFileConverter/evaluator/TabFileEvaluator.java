package pl.edu.pw.zaremba.tabFileConverter.evaluator;

import pl.edu.pw.zaremba.tabFileConverter.api.EvaluationConfigOption;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.LAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.LEM_strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UEM_Strategy;

/**
 * Evaluator class which handles result files evaluation.
 * Created by Mateusz on 2016-06-25.
 */
public class TabFileEvaluator {


    /**
     * Main method, as arguments it recieves full paths to golden file, result
     * file to evaluate and indexes of head and dependency label in files.
     */
    public static void main(String[] args) {

        if (args.length < 4) {
            System.out.println("Podano złą liczbę argumentów wywołania programu");
            System.out.println("Należy podać : pełną ścieżkę do pliku z rozwiązaniem wzorcowym," +
                    "pełną ścieżkę do pliku wynikowego, indeks wyrazu nadrzędnego i indeks" +
                    "związku zależnościowego w plikach wejściowych.");
        } else {
            String goldenPath = args[0];
            String resultPath = args[1];
            int headIndex = Integer.valueOf(args[2]);
            int depLabelIndex = Integer.valueOf(args[3]);

            EvaluationConfigOption config1 = new EvaluationConfigOption(headIndex);
            UAS_Strategy strategy1 = new UAS_Strategy();
            strategy1.loadConfiguration(config1);
            System.out.println(strategy1.evaluate(goldenPath, resultPath));

            EvaluationConfigOption config2 = new EvaluationConfigOption(headIndex, depLabelIndex);
            LAS_Strategy strategy2 = new LAS_Strategy();
            strategy2.loadConfiguration(config2);
            System.out.println(strategy2.evaluate(goldenPath, resultPath));

            EvaluationConfigOption config3 = new EvaluationConfigOption(headIndex);
            UEM_Strategy strategy3 = new UEM_Strategy();
            strategy3.loadConfiguration(config3);
            System.out.println(strategy3.evaluate(goldenPath, resultPath));

            EvaluationConfigOption config4 = new EvaluationConfigOption(headIndex, depLabelIndex);
            LEM_strategy strategy4 = new LEM_strategy();
            strategy4.loadConfiguration(config4);
            System.out.println(strategy4.evaluate(goldenPath, resultPath));
        }
    }
}
