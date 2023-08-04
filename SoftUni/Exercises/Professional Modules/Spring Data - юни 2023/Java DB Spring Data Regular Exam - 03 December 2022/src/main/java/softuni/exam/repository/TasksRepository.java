package softuni.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import softuni.exam.models.entity.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long>{
	
	@Query("SELECT t from Task as t ORDER BY t.price DESC")
	List<Task> findAllOrderByPrice();
}
