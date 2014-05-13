package neo4j.repositories;

import java.util.List;

import neo4j.models.World;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;



public interface WorldRepository extends GraphRepository<World> {
	// MATCH (w) WHERE w:World AND w.name = {0}
	List<World> findByName(String name);
	// MATCH (w) WHERE w:World AND w.moons > {0}
	List<World> findByMoonsGreaterThan(int moons);
}