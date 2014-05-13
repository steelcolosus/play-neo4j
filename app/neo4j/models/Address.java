package neo4j.models;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;

public class Address extends AbstractNode {
	@Indexed
	public String state;
	@Indexed
	public String name;
	@Indexed
	public String city;
	@Fetch
	@RelatedTo(type="LIVES_ON", direction=Direction.INCOMING)
	public UserProfile userProfile;
	
	public Address(String state, String name, String city) {
		// TODO Auto-generated constructor stub
		this.state = state;
		this.name = name;
		this.city = city;
	}
	public Address(){
		
	}
}
