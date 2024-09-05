package src.motorcycle.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MotorcycleYear {
    private String year;
    
    public MotorcycleYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    static Pattern pattern = Pattern.compile("[0-9]{4}");
    public static boolean validateName(MotorcycleYear year){

        Matcher matcher = pattern.matcher(year.toString());
        return matcher.find();

    }
}
