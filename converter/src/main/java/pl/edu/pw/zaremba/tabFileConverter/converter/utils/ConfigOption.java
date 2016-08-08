package pl.edu.pw.zaremba.tabFileConverter.converter.utils;

/**
 * Created by Mateusz on 2016-04-10.
 */
public class ConfigOption {

    private boolean blank;

    private int position;

    public ConfigOption() {
        this.blank = true;
    }

    public ConfigOption(int position){
        this.position = position;
    }

    public boolean isBlank(){
        return blank;
    }

    public int getPosition(){
        return position;
    }
}
