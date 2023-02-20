package hua.group42.rentCar.service;

import hua.group42.rentCar.model.Rent;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface RentService {

    public Rent saveRent(Rent rent);
    public List<Rent> getAllRents();

    @Transactional
    public void deleteRent(int id);
}
