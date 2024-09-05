package src.motorcycle.models;

public class Motorcycle{

    private int id;
    private String marca;
    private String modelo;
    private int cilindradas;
    private String categoria;
    private int ano;

    public Motorcycle(int id ,String marca, String modelo, int cilindradas, String categoria, int ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindradas = cilindradas;
        this.categoria = categoria;
        this.ano = ano;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public static boolean equalsId(Motorcycle motorcycle, int id) {
        return motorcycle.id == id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparação com o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica tipo e nulidade
        Motorcycle that = (Motorcycle) obj;
        return id == that.id; // Comparação de ID para verificar igualdade
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id); // Deve ser consistente com equals
    }

    @Override
    public String toString() {
        return "Motorcycle [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cilindradas=" + cilindradas
                + ", categoria=" + categoria + ", ano=" + ano + "]";
    }

    
}