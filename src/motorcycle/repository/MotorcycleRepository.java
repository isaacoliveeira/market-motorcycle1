package motorcycle.repository;

import java.util.ArrayList;
import java.util.List;

import motorcycle.models.Motorcycle;

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


        public void removeMotorcycle(Motorcycle motorcycle)  {
            if (!motorcycles.contains(motorcycle)) {
                throw new IllegalArgumentException("MOTO NÃO ENCONTRADA");
            }
            motorcycles.remove(motorcycle);
        }

        public void update(Motorcycle oldMotorcycle, Motorcycle newMotorcycle) {
            int index = motorcycles.indexOf(oldMotorcycle);
            if (index != -1) {
                motorcycles.set(index, newMotorcycle);
            }
            throw new IllegalArgumentException("Moto não encontrada");
        }
        
        public void listAllMotorcycles() {
        if (motorcycles.isEmpty()) {
            throw new IllegalArgumentException("NÃO POSSUI MOTOCICLETAS CADASTRADAS");
        }
        for (Motorcycle motorcycles : motorcycles) {
            System.out.println(motorcycles);
            }
        }
        

        public boolean contains(Motorcycle motorcycle) {
            return motorcycles.contains(motorcycle);
        }
    }

