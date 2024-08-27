package src.interfaces;

public interface MotorcycleActionsInterface {
    public void register(int id ,String marca, String modelo, int cilindradas, String categoria, int ano);
    public void remove(int id);
    public void update();
    public void show();
    public void search();
}
