package gr.hua.project.RentCar.service;

import gr.hua.project.RentCar.dao.CarDao;
import gr.hua.project.RentCar.entity.Car;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarDao carDao;

    @Override
    @Transactional
    public List<Car> getCars() {
        return carDao.findAll();
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carDao.save(car);
    }

    @Override
    @Transactional
    public Car findCar(int id) {
        return  carDao.findById(id);
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        carDao.delete(id);
    }
}
