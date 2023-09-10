package hua.group42.rentCar.repository;

import hua.group42.rentCar.model.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepository  extends JpaRepository<Produce, Integer> {
}
