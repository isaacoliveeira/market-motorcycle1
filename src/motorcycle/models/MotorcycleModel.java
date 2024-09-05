package src.motorcycle.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MotorcycleModel {
    private String model;
    
    public MotorcycleModel(String model) {
        this.model = model; 
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
