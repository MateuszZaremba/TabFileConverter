package pl.edu.pw.zaremba.tabFileConverter.evaluator;

import pl.edu.pw.zaremba.tabFileConverter.EvaluationConfigOption;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.LAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UEM_Strategy;

/**
 * Created by Mateusz on 2016-06-25.
 */
public class TabFileEvaluator {


    public static void main(String[] args) {
        EvaluationConfigOption config1 = new EvaluationConfigOption(7);
        UAS_Strategy strategy1 = new UAS_Strategy();
        strategy1.loadConfiguration(config1);
        System.out.println(strategy1.evaluate
                ("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));

        EvaluationConfigOption config2 = new EvaluationConfigOption(7,8);
        LAS_Strategy strategy2 = new LAS_Strategy();
        strategy2.loadConfiguration(config2);
        System.out.println(strategy2.evaluate
                ("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));

        EvaluationConfigOption config3 = new EvaluationConfigOption(7);
        UEM_Strategy strategy3 = new UEM_Strategy();
        strategy3.loadConfiguration(config3);
        System.out.println(strategy3.evaluate
                ("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));
    }
}
