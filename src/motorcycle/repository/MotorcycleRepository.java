package src.motorcycle.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import src.motorcycle.models.Motorcycle;

public class MotorcycleRepository {

        List<Motorcycle> motorcycles = new ArrayList<>();

        public MotorcycleRepository(List<Motorcycle> motorcycles) {
            this.motorcycles = motorcycles;
        }

        public void addMotorcycle(Motorcycle motorcycle)  {
            if (motorcycles.contains(motorcycle)) {
                throw new IllegalArgumentException("A MOTO JÁ EXISTE");
            }
            motorcycles.add(motorcycle);
        }


        @SuppressWarnings("unlikely-arg-type") //mostrou isso pq estou removendo um int sendo que motorcycle é do tipo motorcycle, é um aviso, se algum de voces
        // conseguir fazer de outro jeito pode fazer.
        public void removeMotorcycle(int id)  {
            Motorcycle toRemove = null;
            for (Motorcycle motorcycle : motorcycles) {
                if (motorcycle.equals(id)) {
                    toRemove = motorcycle;
                    break;
                }
            }
            if (toRemove == null) {
                throw new IllegalArgumentException("A MOTO NÃO EXISTE");
            }
            motorcycles.remove(toRemove);
        }

        public void update(int id, String marca, String modelo, int cilindradas, String categoria, int ano) {
            Motorcycle motorcycleToUpdate = null;

            for (Motorcycle motorcycle : motorcycles) {
                if (motorcycle.getId() == id) {
                    motorcycleToUpdate = motorcycle;
                    break;
                }
            }
            
            if (motorcycleToUpdate == null) {
                throw new IllegalArgumentException("NÃO FOI POSSÍVEL ENCONTRAR MOTO COM O ID DADO");
            }

            motorcycleToUpdate.setMarca(marca);
            motorcycleToUpdate.setModelo(modelo);
            motorcycleToUpdate.setCilindradas(cilindradas);
            motorcycleToUpdate.setCategoria(categoria);
            motorcycleToUpdate.setAno(ano);

        }
        
        public void listAllMotorcycles() {
        if (motorcycles.isEmpty()) {
            throw new IllegalArgumentException("NÃO POSSUI MOTOCICLETAS CADASTRADAS");
        }
        for (Motorcycle motorcycles : motorcycles) {
            System.out.println(motorcycles);
            }
        }
        
        public Motorcycle search(int id) {
            for (Motorcycle motorcycle : motorcycles) {
                if (motorcycle.getId() == id) {
                    return motorcycle;
                }
            }
            throw new IllegalArgumentException("MOTO NÃO EXISTE");
        }

        
    }
