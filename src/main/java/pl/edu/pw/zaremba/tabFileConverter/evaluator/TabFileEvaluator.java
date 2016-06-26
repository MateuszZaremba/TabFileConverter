package pl.edu.pw.zaremba.tabFileConverter.evaluator;

import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.LAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UAS_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.strategies.UEM_Strategy;
import pl.edu.pw.zaremba.tabFileConverter.evaluator.utils.ConfigOption;

/**
 * Created by Mateusz on 2016-06-25.
 */
public class TabFileEvaluator {


    public static void main(String[] args) {
//        ConfigOption config = new ConfigOption(7);
//        UAS_Strategy strategy = new UAS_Strategy();
//        strategy.loadConfiguration(config);
//        System.out.println(strategy.evaluate("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
//                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));

//        ConfigOption config1 = new ConfigOption(7,8);
//        LAS_Strategy strategy1 = new LAS_Strategy();
//        strategy1.loadConfiguration(config1);
//        System.out.println(strategy1.evaluate("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
//                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));

        ConfigOption config = new ConfigOption(7);
        UEM_Strategy strategy = new UEM_Strategy();
        strategy.loadConfiguration(config);
        System.out.println(strategy.evaluate("C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\golden",
                "C:\\Users\\Mateusz\\IdeaProjects\\tabFileConverter\\src\\main\\resources\\result"));
    }
}
