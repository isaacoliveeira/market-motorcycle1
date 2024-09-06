package src.motorcycle.service;

import src.interfaces.MotorcycleActionsInterface;
import src.motorcycle.models.*;
import src.motorcycle.repository.MotorcycleRepository;

public class MotorcycleService implements MotorcycleActionsInterface {

    private MotorcycleRepository repository;

    public MotorcycleService(MotorcycleRepository repository){
        this.repository = repository;
    }

    @Override
    public void register(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km km) {
        Motorcycle motorcycle = new Motorcycle(brand, model, cylinderCapacity, year, km);
        repository.addMotorcycle(motorcycle);
    }

    @Override
    public void remove(int id) {
        repository.removeMotorcycle(id);
    }

    @Override
    public void update(Brand brand, Model model, CylinderCapacity cylinderCapacity, Year year, Km km) {
        repository.update(brand, model, cylinderCapacity, year, km);
    }

    @Override
    public void show() {
        repository.listAllMotorcycles();
    }

    @Override
    public void search(int id) {
        Motorcycle motorcycle = repository.search(id);
        if( motorcycle != null) {
            System.out.println(motorcycle.toString());
        }
        throw new IllegalArgumentException("MOTO NÃO ENCONTRADA");
    }

    @Override
    public void register(Brand brand, Model model, CylinderCapacity cylinderCapacity, java.time.Year year, Km Km) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Brand brand, Model model, CylinderCapacity cylinderCapacity, java.time.Year year, Km Km) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
