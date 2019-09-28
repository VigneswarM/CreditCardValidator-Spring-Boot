package SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Bean;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

	
	@Repository
	public interface CardDao extends CrudRepository<Card, String> {

	
}


