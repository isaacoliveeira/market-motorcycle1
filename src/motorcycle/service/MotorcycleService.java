package motorcycle.service;

import interfaces.MotorcycleActionsInterface;
import motorcycle.models.Brand;
import motorcycle.models.CylinderCapacity;
import motorcycle.models.Km;
import motorcycle.models.Model;
import motorcycle.models.Motorcycle;
import motorcycle.models.Year;
import motorcycle.repository.MotorcycleRepository;

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
<<<<<<< HEAD
    public void remove(Brand brand, Model model, CylinderCapacity cylinderCapacity,Year year, Km km) {
        Motorcycle motorcycle = new Motorcycle(brand, model, cylinderCapacity, year, km);
        repository.removeMotorcycle(motorcycle);
=======
    public void remove(Brand brand) {
        repository.removeMotorcycle(brand);
>>>>>>> origin/vinicius
    }

    @Override
    public void update(Motorcycle oldMotorcycle, Motorcycle newMotorcycle) {
        if (repository.contains(oldMotorcycle)) {
            repository.update(oldMotorcycle, newMotorcycle);
        }
        throw new IllegalArgumentException("Moto não encontrada");
    }

    @Override
    public void show() {
        repository.listAllMotorcycles();
    }
<<<<<<< HEAD
=======

    @Override
    public void search(int id) {
        Motorcycle motorcycle = repository.search(id);
        if( motorcycle != null) {
            System.out.println(motorcycle.toString());
        }
        throw new IllegalArgumentException("MOTO NÃO ENCONTRADA");
    }



>>>>>>> origin/vinicius
}
