package pl.edu.pw.zaremba.tabFileConverter.converter;

import pl.edu.pw.zaremba.tabFileConverter.api.TabFileConverter;
import pl.edu.pw.zaremba.tabFileConverter.converter.utils.FileProcessor;
import pl.edu.pw.zaremba.tabFileConverter.converter.utils.ConfigurationLoader;

/**
 * Converter class which handles conversion of tab separated files.
 * Mainly developed from conversion of CoNLL files formats.
 *
 * Created by Mateusz on 2016-04-10.
 */
public class TabFileConverterImpl implements TabFileConverter {

    private static FileProcessor fileProcessor;

    public TabFileConverterImpl() {
        ConfigurationLoader configLoader = new ConfigurationLoader();
        fileProcessor = new FileProcessor(configLoader.loadConfiguration());
    }

    public void convert(String directory, double percentage) {
        fileProcessor.processDirectory(directory, percentage, true);
    }


    public static void main(String[] args) {
        TabFileConverterImpl fileConverter = new TabFileConverterImpl();
        fileConverter.convert("resources", 1);
    }

}