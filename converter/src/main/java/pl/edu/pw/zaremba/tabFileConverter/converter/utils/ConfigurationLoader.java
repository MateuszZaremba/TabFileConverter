package pl.edu.pw.zaremba.tabFileConverter.converter.utils;


import pl.edu.pw.zaremba.tabFileConverter.api.Configuration;
import pl.edu.pw.zaremba.tabFileConverter.api.ConversionConfigOption;

import java.util.TreeMap;

/**
 * Class which loads necesary configuration for TabFileConverter class.
 */
public class ConfigurationLoader {

    public TreeMap<Integer, ConversionConfigOption> loadConfiguration() {
        return Configuration.COPY_CONFIGURATION;
    }

}
