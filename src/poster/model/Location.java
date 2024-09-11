package poster.model;

public class Location {
    private String cidade;
    private String UF;

    public Location(String cidade, String uF) {
        this.cidade = cidade;
        UF = uF;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUF() {
        return UF;
    }
    public void setUF(String uF) {
        UF = uF;
    }

    
}
