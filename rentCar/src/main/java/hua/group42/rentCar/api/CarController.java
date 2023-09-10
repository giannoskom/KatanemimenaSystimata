package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Car;
import hua.group42.rentCar.model.Produce;
import hua.group42.rentCar.service.CarService;
import hua.group42.rentCar.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController { // to controller tou Car
    @Autowired
    private CarService carService;
    @Autowired
    private ProduceService produceService;


    @PostMapping("/add")
    public String add(@RequestBody int id){
        System.out.println(id);
        Produce temp = produceService.findProduceById(id);
        System.out.println(temp);
        Car car = new Car();
        car.setBrand(temp.getBrand().toString());
        car.setModel(temp.getCarModel().toString());
        car.setModelYear(temp.getCarYear().toString());
        System.out.println(car);
        carService.saveCar(car);
        produceService.deleteProduce(id);
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){ // to id epistrefei apo to Delete request san String opote edo otan kalite i deleteRent tis rentService, to id ginete integer prin perasei os parametros.
        carService.deleteCarById(Integer.valueOf(id));
    }

}