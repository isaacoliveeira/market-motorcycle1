package motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import motorcycle.models.CylinderCapacity;


public class CylinderCapacityValidator {

    static Pattern pattern = Pattern.compile("[0,9]{4}");
    public static boolean validateName(CylinderCapacity cylinder){

        Matcher matcher = pattern.matcher(cylinder.toString());
        return matcher.find();

    }
}
