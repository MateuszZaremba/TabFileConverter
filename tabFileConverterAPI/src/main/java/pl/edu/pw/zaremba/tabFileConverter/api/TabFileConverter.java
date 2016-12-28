package pl.edu.pw.zaremba.tabFileConverter.api;


public interface TabFileConverter {

    /**
     * Method which converts all files in given directory
     *
     * @param directory to convert its files
     * @param percentage percentage of train files
     */
    void convert(String directory, double percentage);


}
