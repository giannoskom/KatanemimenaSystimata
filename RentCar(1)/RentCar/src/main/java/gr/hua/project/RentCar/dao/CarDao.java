package gr.hua.project.RentCar.dao;

import gr.hua.project.RentCar.entity.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();

    public void save(Car car);

    public Car findById(int id);

    public void delete(int id);
}
