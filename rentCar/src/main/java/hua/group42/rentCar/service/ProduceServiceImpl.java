package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Produce;
import hua.group42.rentCar.repository.ProduceRepository;
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
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceRepository produceRepository;

    @PersistenceContext
    //https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#dao-annotations
    private EntityManager entityManager;

    public ProduceServiceImpl( ProduceRepository produceRepository) { this.produceRepository = produceRepository;}

    @Override
    public Produce saveProduce(Produce produce) {
        return produceRepository.save(produce);
    }

    @Override
    public Produce findProduceById(int id){ return produceRepository.findById(id).orElse(null); }

    @Override
    @Transactional
    public List<Produce> getAllProduces() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Produce", Produce.class);
        List<Produce> Produces = query.getResultList();
        return Produces;
    }

    @Override
    @Transactional
    public void deleteProduce(int id) {
        produceRepository.deleteById(id);
    }
}
