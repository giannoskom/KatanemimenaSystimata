package gr.hua.project.RentCar.dao;

import gr.hua.project.RentCar.entity.Car;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Car> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Car", Car.class);
        List<Car> cars = query.getResultList();
        return cars;
    }

    @Override
    public void save(Car car) {
        Car acar= entityManager.merge(car);
    }

    @Override
    public Car findById(int id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public void delete(int id) {
        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);
    }
}
