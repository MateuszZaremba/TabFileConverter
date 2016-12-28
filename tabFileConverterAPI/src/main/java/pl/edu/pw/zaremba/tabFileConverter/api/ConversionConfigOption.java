package pl.edu.pw.zaremba.tabFileConverter.api;

/**
 * Options which represent conversion configuration.
 *
 * Created by Mateusz on 2016-04-10.
 */
public class ConversionConfigOption {

    private boolean blank;

    private int position;

    public ConversionConfigOption() {
        this.blank = true;
    }

    public ConversionConfigOption(int position){
        this.position = position;
    }

    public boolean isBlank(){
        return blank;
    }

    public int getPosition(){
        return position;
    }
}
