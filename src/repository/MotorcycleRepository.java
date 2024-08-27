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

        






    
}
