package gr.hua.project.RentCar.service;

import gr.hua.project.RentCar.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCars() ;

    public void saveCar(Car car);

    public Car findCar(int id);

    public void deleteCar(int id);
}
