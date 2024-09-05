package src.motorcycle.service;

import src.interfaces.MotorcycleActionsInterface;
import src.motorcycle.models.Motorcycle;
import src.motorcycle.repository.MotorcycleRepository;

public class MotorcycleService implements MotorcycleActionsInterface {

    private MotorcycleRepository repository;

    public MotorcycleService(MotorcycleRepository repository){
        this.repository = repository;
    }

    @Override
    public void register(int id,String marca, String modelo, int cilindradas, String categoria, int ano) {
        Motorcycle motorcycle = new Motorcycle(id,marca, modelo, cilindradas , categoria, ano);
        repository.addMotorcycle(motorcycle);
    }

    @Override
    public void remove(int id) {
        repository.removeMotorcycle(id);
    }

    @Override
    public void update(int id ,String marca, String modelo, int cilindradas, String categoria, int ano) {
        repository.update(id, marca, modelo, cilindradas, categoria, ano);
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

}
