package src.motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.motorcycle.models.MotorcycleBrand;


public class BrandValidator {
    
    static Pattern pattern = Pattern.compile("[a-zA-Z]{15}");
    public static boolean validateName(MotorcycleBrand brand){

        Matcher matcher = pattern.matcher(brand.toString());
        return matcher.find();
    }
    
}
