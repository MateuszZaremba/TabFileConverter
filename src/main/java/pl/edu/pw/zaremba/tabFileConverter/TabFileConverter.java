package pl.edu.pw.zaremba.tabFileConverter;

import pl.edu.pw.zaremba.tabFileConverter.utils.ConfigurationLoader;
import pl.edu.pw.zaremba.tabFileConverter.utils.FileManager;

/**
 * Created by Mateusz on 2016-04-10.
 */
public class TabFileConverter {

    private static FileManager fileManager;

    public TabFileConverter() {
        ConfigurationLoader configLoader = new ConfigurationLoader();
        fileManager = new FileManager(configLoader.loadConfiguration());
    }

    public void convert(String directory, double percentage) {
        fileManager.processDirectory(directory, percentage, true);
    }


    public static void main(String[] args) {
        TabFileConverter fileConverter = new TabFileConverter();
        fileConverter.convert("resources", 0.8);
    }

}