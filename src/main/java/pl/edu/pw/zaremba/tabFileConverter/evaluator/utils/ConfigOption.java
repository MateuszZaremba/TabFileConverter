package pl.edu.pw.zaremba.tabFileConverter.evaluator.utils;

/**
 * Created by Mateusz on 2016-06-25.
 */
public class ConfigOption {

    private int headPosition;

    private int labelPosition;

    public ConfigOption(int headPosition) {
        this.headPosition = headPosition;
    }

    public ConfigOption(int headPosition, int labelPosition) {
        this.headPosition = headPosition;
        this.labelPosition = labelPosition;
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public void setHeadPosition(int headPosition) {
        this.headPosition = headPosition;
    }

    public int getLabelPosition() {
        return labelPosition;
    }

    public void setLabelPosition(int labelPosition) {
        this.labelPosition = labelPosition;
    }
}
