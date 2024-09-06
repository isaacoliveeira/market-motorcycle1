package src.interfaces;

import java.time.Year;
import src.motorcycle.models.Brand;
import src.motorcycle.models.CylinderCapacity;
import src.motorcycle.models.Km;
import src.motorcycle.models.Model;

public interface MotorcycleActionsInterface {
    public void register(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km Km);
    public void remove(int id);
    public void update(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km Km);
    public void show();
    public void search(int id);
}
