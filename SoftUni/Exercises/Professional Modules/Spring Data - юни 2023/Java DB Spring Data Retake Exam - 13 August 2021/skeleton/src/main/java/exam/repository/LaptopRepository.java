package exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import exam.model.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
	
	boolean existsByMacAddress(String macAddress);
	
	@Query("SELECT l from Laptop l ORDER BY l.cpuSpeed DESC, l.ram DESC, l.storage DESC, l.macAddress")
	List<Laptop> findOrderedLaptops();
}
