package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softuni.exam.models.entity.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long>{

	Car findByPlateNumber(String plateNumber);
}
