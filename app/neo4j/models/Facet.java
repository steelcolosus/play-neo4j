package neo4j.models;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;

public class Facet extends AbstractNode{
	
	@Indexed
	public String name;
	
	@Fetch
	@RelatedTo(type="HAS_FACET", direction=Direction.INCOMING)
	public Set<UserProfile> userProfile=new HashSet<UserProfile>();
	
	
	public Facet(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public Facet(){
		
	}

}
