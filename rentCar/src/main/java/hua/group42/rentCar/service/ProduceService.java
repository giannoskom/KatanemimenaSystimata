package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Produce;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProduceService {

    public Produce saveProduce(Produce produce);
    public List<Produce> getAllProduces();

    public Produce findProduceById(int id);
    @Transactional
    public void deleteProduce(int id);
}
