package id.ac.ui.cs.advpro.eshop.controller;
import id.ac.ui.cs.advpro.eshop.model.Car;
import id.ac.ui.cs.advpro.eshop.model.Product;
import id.ac.ui.cs.advpro.eshop.service.CarService;
import id.ac.ui.cs.advpro.eshop.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
/**
 * Handles operations for creating, listing, and editing products in the application.
 */
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
    
    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable("productId") String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PutMapping("/edit")
    public String editProductPost(@ModelAttribute("product") Product product) {
        service.updateProduct(product);
        return "redirect:list";
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        service.deleteProduct(productId);
        return "redirect:../list";
    }
}

@Controller
@RequestMapping("/car")
class CarController extends ProductController {
    @Autowired
    private CarService carService;

    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }

    @PostMapping
    public String createCarPost(@ModelAttribute Car car, Model model) {
        carService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model) {
        List<Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "EditCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        System.out.println(car.getCarId());
        carService.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@ModelAttribute("carId") String carId) {
        carService.delete(carId);
        return "redirect:listCar";
    }
}