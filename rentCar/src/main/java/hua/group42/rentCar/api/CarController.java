package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Car;
import hua.group42.rentCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController { // to controller tou Car
    @Autowired
    private CarService carService;


    @PostMapping("/add")
    public String add(@RequestBody Car car){
        carService.saveCar(car);
        return "Success";
    }

    @GetMapping("/getList")
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    Car get(@PathVariable int id) {
        return carService.getAllCars().stream().filter(car -> id == car.getId()).findAny().orElse(null);
    }

}