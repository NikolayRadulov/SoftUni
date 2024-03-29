package exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exam.model.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	Shop findByName(String name);
}
