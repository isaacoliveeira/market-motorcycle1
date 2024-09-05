package src.motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.motorcycle.models.MotorcycleCylinderCapacity;

public class CylinderCapacityValidator {

    static Pattern pattern = Pattern.compile("[0,9]{4}");
    public static boolean validateName(MotorcycleCylinderCapacity cylinder){

        Matcher matcher = pattern.matcher(cylinder.toString());
        return matcher.find();

    }
}
