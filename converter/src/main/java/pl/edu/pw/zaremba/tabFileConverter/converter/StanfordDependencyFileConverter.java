package pl.edu.pw.zaremba.tabFileConverter.converter;

import pl.edu.pw.zaremba.tabFileConverter.converter.utils.FileProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which handles conversion of Stanford typed dependency files into CoNLL files.
 */
public class StanfordDependencyFileConverter extends FileProcessor {

    private Map<Integer, String> linesMap;

    public StanfordDependencyFileConverter() {
        super(null);
        linesMap = new HashMap<>();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Należy podać nazwę katalogu z plikami do konwersji.");
        } else {
            String resourceCatalogName = args[0];
            StanfordDependencyFileConverter converter = new StanfordDependencyFileConverter();
            converter.processDirectory(resourceCatalogName, 1, true);
        }
    }


    @Override
    protected String processLine(String line) {
        if (line.isEmpty()) {
            String res = produceOutput();
            linesMap = new HashMap<>();
            return res;
        }
        char[] chars = line.toCharArray();
        String type = "";
        String head = "";
        String noun = "";
        String id = "";
        boolean typeB = false;
        for (int i = 0; i < chars.length; i++) {
            if (!typeB) {
                if (chars[i] != '(') {
                    type += chars[i];
                } else {
                    typeB = true;
                }
            } else {
                while (chars[i] != ' ') {
                    i++;
                }
                int j = i--;
                while (chars[i] != '-') {
                    i--;
                }
                for (int k = i + 1; k < j; k++) {
                    if (chars[k] != ',') {
                        head += chars[k];
                    }
                }
                break;
            }
        }
        int i = chars.length - 1;
        while (chars[i] != '-') {
            i--;
        }
        int k = i + 1;
        int j = i;
        while (chars[k] != ')') {
            id += chars[k];
            k++;
        }
        int l = j + 1;
        while (chars[l] != ' ') {
            l--;
        }
        while (l != j) {
            noun += chars[l];
            l++;
        }
        StringBuilder builder = new StringBuilder();


        builder.append(id)
                .append("\t")
                .append(noun)
                .append("\t")
                .append(noun)
                .append("\t")
                .append("_")
                .append("\t")
                .append("-")
                .append("\t")
                .append("-")
                .append("\t")
                .append(head)
                .append("\t")
                .append(type)
                .append("\t")
                .append("-")
                .append("\t")
                .append("-")
                .append("\n");

        linesMap.put(Integer.valueOf(id), builder.toString());

        return null;
    }

    private String produceOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= linesMap.keySet().size(); i++) {
            stringBuilder.append(linesMap.get(i));
        }
        return stringBuilder.toString();
    }
}
