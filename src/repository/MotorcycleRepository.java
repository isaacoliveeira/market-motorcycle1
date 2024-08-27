package src.repository;

import java.util.ArrayList;
import java.util.List;

import src.model.Motorcycle;

public class MotorcycleRepository {

        List<Motorcycle> motorcycles = new ArrayList<>();

        public void addMotorcycle(Motorcycle motorcycle) throws Exception{
            if (motorcycles.contains(motorcycle)) {
                throw new Exception("A MOTO JÁ EXISTE");
            }
            motorcycles.add(motorcycle);
        }

        public void removeMotorcycle(Motorcycle motorcycle) throws Exception {
            if (!motorcycles.contains(motorcycle)) {
                throw new Exception("A MOTO NÃO EXISTE");
            }
            motorcycles.remove(motorcycle);
        }

        public void listAllMotorcycles() throws Exception {
        if (motorcycles.isEmpty()) {
            throw new Exception("NÃO POSSUI MOTOCICLETAS CADASTRADAS");
        }
        for (Motorcycle motorcycles : motorcycles) {
            System.out.println(motorcycles);
            }
        }

        public void searchMotorcycle(Motorcycle motorcycle) throws Exception {
            if (!motorcycles.contains(motorcycle)){
                throw new Exception("MOTO NÃO EXISTE");
            }
            motorcycle.toString();
        }
    }

