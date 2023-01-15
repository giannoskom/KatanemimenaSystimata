package gr.hua.project.RentCar.controller;

import gr.hua.project.RentCar.entity.Car;
import gr.hua.project.RentCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class    CarController {

    @Autowired
    private CarService carService ;

    @GetMapping("/CarList")
    List<Car> getall() {
        return carService.getCars();
    }

    @PostMapping("")
    Car save(@Validated @RequestBody Car car) {
        car.setId(0);
        carService.saveCar(car);
        return car;
    }

    @GetMapping("/{id}")
    Car get(@PathVariable int id) {
        Car car = carService.findCar(id);
        return car;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        carService.deleteCar(id);
    }
}
