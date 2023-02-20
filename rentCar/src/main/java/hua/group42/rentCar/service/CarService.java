package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Car;

import java.util.List;

public interface CarService {
    public Car saveCar(Car car);

    public List<Car> getAllCars();

    public String deleteCar(int id);
}
