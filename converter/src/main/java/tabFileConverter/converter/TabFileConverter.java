package tabFileConverter.converter;

import tabFileConverter.converter.utils.ConfigurationLoader;
import tabFileConverter.converter.utils.FileProcessor;

/**
 * Created by Mateusz on 2016-04-10.
 */
public class TabFileConverter {

    private static FileProcessor fileProcessor;

    public TabFileConverter() {
        ConfigurationLoader configLoader = new ConfigurationLoader();
        fileProcessor = new FileProcessor(configLoader.loadConfiguration());
    }

    public void convert(String directory, double percentage) {
        fileProcessor.processDirectory(directory, percentage, true);
    }


    public static void main(String[] args) {
        TabFileConverter fileConverter = new TabFileConverter();
        fileConverter.convert("resources", 1);
    }

}