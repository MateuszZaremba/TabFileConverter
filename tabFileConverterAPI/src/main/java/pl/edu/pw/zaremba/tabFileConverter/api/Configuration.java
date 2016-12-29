package pl.edu.pw.zaremba.tabFileConverter.api;

import java.util.TreeMap;

/**
 * Pre built configurations for file converter.
 */
public class Configuration {

    public static final TreeMap<Integer, ConversionConfigOption> COPY_CONFIGURATION;

    public static final TreeMap<Integer, ConversionConfigOption> MATE_CONFIGURATION;

    public static final TreeMap<Integer, ConversionConfigOption> MALT_CONFIGURATION;

    public static final TreeMap<Integer, ConversionConfigOption> YARA_CONFIGURATION;

    public static final TreeMap<Integer, ConversionConfigOption> CLEAR_NLP_CONFIGURATION;

    static{
        COPY_CONFIGURATION = new TreeMap<>();
        COPY_CONFIGURATION.put(1, new ConversionConfigOption(1));
        COPY_CONFIGURATION.put(2, new ConversionConfigOption(2));
        COPY_CONFIGURATION.put(3, new ConversionConfigOption(3));
        COPY_CONFIGURATION.put(4, new ConversionConfigOption(4));
        COPY_CONFIGURATION.put(5, new ConversionConfigOption(5));
        COPY_CONFIGURATION.put(6, new ConversionConfigOption(6));
        COPY_CONFIGURATION.put(7, new ConversionConfigOption(7));
        COPY_CONFIGURATION.put(8, new ConversionConfigOption(8));
        COPY_CONFIGURATION.put(9, new ConversionConfigOption(9));
        COPY_CONFIGURATION.put(10, new ConversionConfigOption(10));

        MATE_CONFIGURATION = new TreeMap<>();
        MATE_CONFIGURATION.put(1, new ConversionConfigOption(1));
        MATE_CONFIGURATION.put(2, new ConversionConfigOption(1));
        MATE_CONFIGURATION.put(3, new ConversionConfigOption(2));
        MATE_CONFIGURATION.put(4, new ConversionConfigOption(3));
        MATE_CONFIGURATION.put(5, new ConversionConfigOption(3));
        MATE_CONFIGURATION.put(6, new ConversionConfigOption());
        MATE_CONFIGURATION.put(7, new ConversionConfigOption());
        MATE_CONFIGURATION.put(8, new ConversionConfigOption(6));
        MATE_CONFIGURATION.put(9, new ConversionConfigOption(6));
        MATE_CONFIGURATION.put(10, new ConversionConfigOption(7));
        MATE_CONFIGURATION.put(11, new ConversionConfigOption(7));
        MATE_CONFIGURATION.put(12, new ConversionConfigOption());
        MATE_CONFIGURATION.put(13, new ConversionConfigOption());
        MATE_CONFIGURATION.put(14, new ConversionConfigOption());
        MATE_CONFIGURATION.put(15, new ConversionConfigOption());
        MATE_CONFIGURATION.put(16, new ConversionConfigOption());
        MATE_CONFIGURATION.put(17, new ConversionConfigOption());

        MALT_CONFIGURATION = new TreeMap<>();
        MALT_CONFIGURATION.put(1, new ConversionConfigOption(1));
        MALT_CONFIGURATION.put(2, new ConversionConfigOption(2));
        MALT_CONFIGURATION.put(3, new ConversionConfigOption(3));
        MALT_CONFIGURATION.put(4, new ConversionConfigOption());
        MALT_CONFIGURATION.put(5, new ConversionConfigOption(4));
        MALT_CONFIGURATION.put(6, new ConversionConfigOption(5));
        MALT_CONFIGURATION.put(7, new ConversionConfigOption(6));
        MALT_CONFIGURATION.put(8, new ConversionConfigOption(7));
        MALT_CONFIGURATION.put(9, new ConversionConfigOption());
        MALT_CONFIGURATION.put(10, new ConversionConfigOption());

        YARA_CONFIGURATION = new TreeMap<>();
        YARA_CONFIGURATION.put(1, new ConversionConfigOption(1));
        YARA_CONFIGURATION.put(2, new ConversionConfigOption(2));
        YARA_CONFIGURATION.put(3, new ConversionConfigOption());
        YARA_CONFIGURATION.put(4, new ConversionConfigOption(4));
        YARA_CONFIGURATION.put(5, new ConversionConfigOption(4));
        YARA_CONFIGURATION.put(6, new ConversionConfigOption());
        YARA_CONFIGURATION.put(7, new ConversionConfigOption(6));
        YARA_CONFIGURATION.put(8, new ConversionConfigOption(7));
        YARA_CONFIGURATION.put(9, new ConversionConfigOption());
        YARA_CONFIGURATION.put(10, new ConversionConfigOption());

        CLEAR_NLP_CONFIGURATION = new TreeMap<>();

        CLEAR_NLP_CONFIGURATION.put(1, new ConversionConfigOption(1));
        CLEAR_NLP_CONFIGURATION.put(2, new ConversionConfigOption(2));
        CLEAR_NLP_CONFIGURATION.put(3, new ConversionConfigOption(3));
        CLEAR_NLP_CONFIGURATION.put(4, new ConversionConfigOption(4));
        CLEAR_NLP_CONFIGURATION.put(5, new ConversionConfigOption(4));
        CLEAR_NLP_CONFIGURATION.put(6, new ConversionConfigOption(6));
        CLEAR_NLP_CONFIGURATION.put(7, new ConversionConfigOption(7));
        CLEAR_NLP_CONFIGURATION.put(8, new ConversionConfigOption(8));
        CLEAR_NLP_CONFIGURATION.put(9, new ConversionConfigOption(9));
        CLEAR_NLP_CONFIGURATION.put(10, new ConversionConfigOption(10));
    }


}
