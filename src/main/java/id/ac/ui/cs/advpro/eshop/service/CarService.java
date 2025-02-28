package id.ac.ui.cs.advpro.eshop.service;
import id.ac.ui.cs.advpro.eshop.model.Car;
import java.util.List;

public interface CarService {
    public Car create(Car car);
    public List<Car> findAll();
    Car findById(String id);
    public void update(String carId, Car car);
    public void delete(String carId);
}
