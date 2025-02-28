package id.ac.ui.cs.advpro.eshop.controller;
import id.ac.ui.cs.advpro.eshop.controller.ProductController;
import id.ac.ui.cs.advpro.eshop.model.Car;
import id.ac.ui.cs.advpro.eshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        model.addAttribute("car", new Car());
        return "CreateCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car) {
        carService.create(car);
        return "redirect:/car/listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "CarList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return "EditCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car) {
        carService.update(car.getCarId(), car);
        return "redirect:/car/listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId) {
        carService.deleteCarById(carId);
        return "redirect:/car/listCar";
    }
}