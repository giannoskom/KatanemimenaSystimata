package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Rent;
import hua.group42.rentCar.repository.RentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService{ // to Service tou Rent

    @Autowired
    private RentRepository rentRepository;
    @PersistenceContext
    //https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#dao-annotations
    private EntityManager entityManager;

    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }

    public Optional<Rent> findRent(int id){ return rentRepository.findById(id); }


    @Override
    @Transactional
    public List<Rent> getAllRents() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Rent", Rent.class);
        List<Rent> Rents = query.getResultList();
        return Rents;
    }

    @Override
    @Transactional
    public void deleteRent(int id) {
        rentRepository.deleteById(id);
    }
}
