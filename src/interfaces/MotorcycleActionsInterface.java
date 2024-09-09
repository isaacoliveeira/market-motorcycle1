package interfaces;

import motorcycle.models.Year;
import motorcycle.models.Brand;
import motorcycle.models.CylinderCapacity;
import motorcycle.models.Km;
import motorcycle.models.Model;

public interface MotorcycleActionsInterface {
    public void register(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km Km);
    public void remove(int id);
    public void update(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km Km);
    public void show();
    public void search(int id);
}
