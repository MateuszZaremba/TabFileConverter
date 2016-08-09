package pl.edu.pw.zaremba.tabFileConverter.converter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.pw.zaremba.tabFileConverter.api.ConversionConfigOption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

/**
 * Class which handles all operations on files for TabFileConverter class.
 * <p>
 * Created by Mateusz on 2016-04-10.
 */
public class FileProcessor {

    private TreeMap<Integer, ConversionConfigOption> lineMapping;

    private final Logger log = LoggerFactory.getLogger(getClass());

    private int sentenceCounter = 0;

    public FileProcessor(TreeMap<Integer, ConversionConfigOption> configuration) {
        this.lineMapping = configuration;
    }


    public void processDirectory(String directory, double percentage, boolean singleFile) {
        try {
            Files.walk(Paths.get(directory)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    log.info(filePath.toString());
                    processFile(filePath.toString(), percentage, singleFile);
                }
            });
            log.info("TOTAL NUMBER OF SENTENCES : {}", sentenceCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void processFile(String filePath, double percentage, boolean singleFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int trainCount = 0;
            int testCount = 0;

            FileOutputStream fos1;
            FileOutputStream fos2;

            if(!singleFile){
                fos1 = new FileOutputStream(filePath + "_converted_train",true);
                fos2 = new FileOutputStream(filePath + "_converted_test", true);
            }else{
                fos1 = new FileOutputStream( "TRAIN_File", true);
                fos2 = new FileOutputStream( "TEST_File", true);
            }


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
                    sentenceCounter++;
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
            ConversionConfigOption option = lineMapping.get(position);
            if (option.isBlank()) {
                builder.append("_").append("\t");
            } else {
                builder.append(splittedLine[option.getPosition() - 1]).append("\t");
            }
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

}
