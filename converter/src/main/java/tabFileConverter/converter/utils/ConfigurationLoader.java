package tabFileConverter.converter.utils;

import java.util.TreeMap;

/**
 * Class which loads necesary configuration for converter
 * <p>
 * Created by Mateusz on 2016-04-10.
 */
public class ConfigurationLoader {

    public TreeMap<Integer, ConfigOption> loadConfiguration() {
        TreeMap<Integer, ConfigOption> options = new TreeMap<>();
//        options.put(1, new ConfigOption(1));
//        options.put(2, new ConfigOption(1));
//        options.put(3, new ConfigOption(2));
//        options.put(4, new ConfigOption(3));      //konfiguracja dla Mate
//        options.put(5, new ConfigOption(3));
//        options.put(6, new ConfigOption());
//        options.put(7, new ConfigOption());
//        options.put(8, new ConfigOption(6));
//        options.put(9, new ConfigOption(6));
//        options.put(10, new ConfigOption(7));
//        options.put(11, new ConfigOption(7));
//        options.put(12, new ConfigOption());
//        options.put(13, new ConfigOption());
//        options.put(14, new ConfigOption());
//        options.put(15, new ConfigOption());
//        options.put(16, new ConfigOption());
//        options.put(17, new ConfigOption());
//
//        options.put(1, new ConfigOption(1));
//        options.put(2, new ConfigOption(2));
//        options.put(3, new ConfigOption(3));
//        options.put(4, new ConfigOption(4));
//        options.put(5, new ConfigOption(4));      //konfiguracja dla ClearNLP
//        options.put(6, new ConfigOption(6));
//        options.put(7, new ConfigOption(7));
//        options.put(8, new ConfigOption(8));
//        options.put(9, new ConfigOption(9));
//        options.put(10, new ConfigOption(10));

//        options.put(1, new ConfigOption(1));
//        options.put(2, new ConfigOption(2));
//        options.put(3, new ConfigOption());
//        options.put(4, new ConfigOption(4));
//        options.put(5, new ConfigOption(4));      //konfiguracja dla Yara
//        options.put(6, new ConfigOption());
//        options.put(7, new ConfigOption(6));
//        options.put(8, new ConfigOption(7));
//        options.put(9, new ConfigOption());
//        options.put(10, new ConfigOption());

//        options.put(1, new ConfigOption(1));
//        options.put(2, new ConfigOption(2));
//        options.put(3, new ConfigOption(3));
//        options.put(4, new ConfigOption());     //konfiguracja dla Malt
//        options.put(5, new ConfigOption(4));
//        options.put(6, new ConfigOption(5));
//        options.put(7, new ConfigOption(6));
//        options.put(8, new ConfigOption(7));
//        options.put(9, new ConfigOption());
//        options.put(10, new ConfigOption());

        options.put(1, new ConfigOption(1));
        options.put(2, new ConfigOption(2));
        options.put(3, new ConfigOption(3));
        options.put(4, new ConfigOption(4));     //konfiguracja kopiujaca
        options.put(5, new ConfigOption(5));
        options.put(6, new ConfigOption(6));
        options.put(7, new ConfigOption(7));
        options.put(8, new ConfigOption(8));
        options.put(9, new ConfigOption(9));
        options.put(10, new ConfigOption(10));


        return options;
    }

}
