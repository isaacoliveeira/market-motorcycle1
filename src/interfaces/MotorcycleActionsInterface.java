package interfaces;

import motorcycle.models.Year;
import motorcycle.models.Brand;
import motorcycle.models.CylinderCapacity;
import motorcycle.models.Km;
import motorcycle.models.Model;

public interface MotorcycleActionsInterface {
    public void register(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km Km);
    public void remove(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km km);
    public void update(Motorcycle oldMotorcycle, Motorcycle newMotorcycle);
    public void show();
}
