package src.motorcycle.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Year {
    private String year;
    
    public Year(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    static Pattern pattern = Pattern.compile("[0-9]{4}");
    public static boolean validateName(Year year){

        Matcher matcher = pattern.matcher(year.toString());
        return matcher.find();

    }
}
