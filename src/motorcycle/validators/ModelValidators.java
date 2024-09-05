package src.motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.motorcycle.models.MotorcycleYear;

public class ModelValidators {
        static Pattern pattern = Pattern.compile("[0-9]{4}");
    public static boolean validateName(MotorcycleYear year){

        Matcher matcher = pattern.matcher(year.toString());
        return matcher.find();

    }
}