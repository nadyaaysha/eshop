package id.ac.ui.cs.advpro.eshop.service;

import id.ac.ui.cs.advpro.eshop.model.Car;
import java.util.List;

public interface CarService {
    Car create(Car car);
    List<Car> findAll();
    Car findById(String id);
    void update(String carId, Car car);
    void deleteCarById(String carId);
}
