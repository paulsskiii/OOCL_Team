package ita.bootcamp.trackingservice.service;

import ita.bootcamp.trackingservice.model.CargoItem;
import ita.bootcamp.trackingservice.model.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    // GET ALL CARGO
    public List<CargoItem> getAllCargoItems(){
        return cargoRepository.findAll();
    }

    // GET SPECIFIC CARGO
    public CargoItem getCargoItemById(Long id){
        return cargoRepository.findById(id).orElse(null);
    }

    // SAVE CARGO
    public CargoItem saveCargoItem(CargoItem cargoItem){
        return cargoRepository.save(cargoItem);
    }

    // UPDATE CARGO
    public CargoItem updateCargoItem(Long id, CargoItem cargoItem){
        CargoItem foundCargo = cargoRepository.findById(id).orElse(null);
        if(foundCargo != null){
            foundCargo.setName(cargoItem.getName());
            foundCargo.setDestination(cargoItem.getDestination());
            foundCargo.setWeight(cargoItem.getWeight());
            foundCargo.setOrigin(cargoItem.getOrigin());
            foundCargo.setDestination(cargoItem.getDestination());
            return cargoRepository.save(foundCargo);
        }
        return null;
    }

    // DELETE CARGO
    public void deleteCargoItem(Long id){
        cargoRepository.deleteById(id);
    }

}
