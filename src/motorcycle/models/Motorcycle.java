package src.motorcycle.models;


public class Motorcycle{

    private int id;
    private Brand brand;
    private Model model;
    private CylinderCapacity cylinder;
    private Year year;
    private Km km;

    public Motorcycle(Brand brand, Model model, CylinderCapacity cylinder, Year year, Km km) {
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
        this.year = year;
        this.km = km;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(Brand brand) {
        this.brand = brand;
    }


    public void setModel(Model model) {
        this.model = model;
    }

    public void setCylinder(CylinderCapacity cylinder) {
        this.cylinder = cylinder;
    }

    public void setCylinderyear(Year year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setKm(Km km) {
        this.km = km;
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
        return "Motorcycle [id=" + id + ", Model=" + ", model=" + model + ", cylinder=" + cylinder
                + ", year=" + year + "]";
    }

    
}