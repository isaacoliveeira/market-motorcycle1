package poster.model;

public class Description {
    private String description;

    public Description(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrition) {
        this.description = descrition;
    } 

    @Override
    public String toString() {
        return description.toString();
    }
}
