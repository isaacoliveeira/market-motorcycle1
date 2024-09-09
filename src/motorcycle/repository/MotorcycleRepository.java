package motorcycle.repository;

import java.util.ArrayList;
import java.util.List;

import motorcycle.models.Motorcycle;
import motorcycle.models.CylinderCapacity;
import motorcycle.models.Year;
import motorcycle.models.Brand;
import motorcycle.models.Km;
import motorcycle.models.Model;


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


        public void removeMotorcycle(Brand brand)  {
            if (!motorcycles.contains(brand)) {
                throw new IllegalArgumentException("MOTO NÃO ENCONTRADA");
            }
            motorcycles.remove(brand);
        }

        public void update(int id,Brand brand, Model model, CylinderCapacity cylinder, Year year, Km km) {
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

            motorcycleToUpdate.setModel(model);
            motorcycleToUpdate.setCylinder(cylinder);
            motorcycleToUpdate.setYear(year);
            motorcycleToUpdate.setKm(km);

        }
        
        public void listAllMotorcycles() {
        if (motorcycles.isEmpty()) {
            throw new IllegalArgumentException("NÃO POSSUI MOTOCICLETAS CADASTRADAS");
        }
        for (Motorcycle motorcycles : motorcycles) {
            System.out.println(motorcycles);
            }
        }
        
        public Motorcycle search(Brand brand) {
            for (Motorcycle motorcycle : motorcycles) {
                if (motorcycle.getBrand().equals(brand)) {
                    return motorcycle;
                }
            }
            throw new IllegalArgumentException("MOTO NÃO EXISTE");
        }
    }

