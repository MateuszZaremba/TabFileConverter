package pl.edu.pw.zaremba.tabFileConverter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

/**
 * Class which handles all operations on files
 * <p>
 * Created by Mateusz on 2016-04-10.
 */
public class FileManager {

    private TreeMap<Integer, ConfigOption> lineMapping;

    private final Logger log = LoggerFactory.getLogger(getClass());

    public FileManager(TreeMap<Integer, ConfigOption> configuration) {
        this.lineMapping = configuration;
    }


    public void processDirectory(String directory, double percentage) {
        try {
            Files.walk(Paths.get(directory)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    log.info(filePath.toString());
                    processFile(filePath.toString(), percentage);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void processFile(String filePath, double percentage) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int trainCount = 0;
            int testCount = 0;

            FileOutputStream fos1 = new FileOutputStream(filePath + "_converted_train");
            FileOutputStream fos2 = new FileOutputStream(filePath + "_converted_test");

            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));

            String currentLine;
            int border = (int)(10 * percentage);
            int counter = 1;

            while (br.ready()) {
                if(counter >= border){
                    currentLine = processLine(br.readLine());
                    bw2.write(currentLine);
                    bw2.newLine();
                }else{
                    currentLine = processLine(br.readLine());
                    bw1.write(currentLine);
                    bw1.newLine();
                }
                if (currentLine.equals("")){
                    counter = (++counter)%10;
                    if(counter >= border){
                        testCount++;
                    }else{
                        trainCount++;
                    }
                }
            }
            bw1.close();
            bw2.close();
            log.info("TRAIN : " + trainCount);
            log.info("TEST : " + testCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String processLine(String line) {
        if (line.isEmpty()) {
            return "";
        }
        String[] splittedLine = line.split("\\t"); //splitted by tabulation
        StringBuilder builder = new StringBuilder();
        for (Integer position : lineMapping.keySet()) {
            ConfigOption option = lineMapping.get(position);
            if (option.isBlank()) {
                builder.append("-").append("\t");
            } else {
                builder.append(splittedLine[option.getPosition() - 1]).append("\t");
            }
        }
        return builder.toString();
    }

}
