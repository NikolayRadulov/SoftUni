package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softuni.exam.models.entity.Mechanic;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanic, Long>{

	Mechanic findByFirstName(String firstName);
}
