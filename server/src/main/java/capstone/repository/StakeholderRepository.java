package capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import capstone.model.User;

@RepositoryRestResource
public interface StakeholderRepository extends JpaRepository<User, Long> 
{
	
}
