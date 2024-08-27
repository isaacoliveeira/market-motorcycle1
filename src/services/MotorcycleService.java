package src.services;

import src.interfaces.MotorcycleActionsInterface;
import src.model.Motorcycle;
import src.repository.MotorcycleRepository;

public class MotorcycleService implements MotorcycleActionsInterface {

    @Override
    public void register(int id,String marca, String modelo, int cilindradas, String categoria, int ano) {
        Motorcycle motorcycle = new Motorcycle(id,marca, modelo, cilindradas , categoria, ano); 
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void show() {
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
