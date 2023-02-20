package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Car;
import hua.group42.rentCar.repository.CarRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{ // to service tou Car
    @Autowired
    private CarRepository carRepository;

    @PersistenceContext //https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#dao-annotations
    private EntityManager entityManager;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public List<Car> getAllCars(){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Car", Car.class);
        List<Car> Cars = query.getResultList();
        return Cars;
    }


    @Override
    @Transactional
    public String deleteCar(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Car", Car.class);

        return "Car with id = " + id + " deleted successfully";
    }
}
