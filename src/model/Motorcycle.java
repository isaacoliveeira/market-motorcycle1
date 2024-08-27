package src.model;

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


}