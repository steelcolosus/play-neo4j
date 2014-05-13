package neo4j.repositories;

import neo4j.models.UserProfile;
import neo4j.models.World;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface  UserProfileRepository extends GraphRepository<UserProfile>{

}
