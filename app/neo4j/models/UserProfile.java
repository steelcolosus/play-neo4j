package neo4j.models;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class UserProfile extends AbstractNode{

	@Indexed
	public String name;
	
	@Indexed
	public String gender;
	
	@Indexed
	public String title;
	
	@Indexed
	public Long DateOfBirth;
	
	@Fetch
	@RelatedTo(type="HAS_FACET", direction=Direction.OUTGOING)
	public Set<Facet> userFacet=new HashSet<Facet>();
	
	@Fetch
	@RelatedTo(type="LIVES_ON", direction=Direction.OUTGOING)
	public Set<Address> userAddress=new HashSet<Address>();
	
	
	@Fetch
	@RelatedTo(type="FRIEND_WITH", direction=Direction.OUTGOING)
	public Set<UserProfile> userFriends=new HashSet<UserProfile>();
	
	
	public UserProfile(String name, String gender, String title, Long DateOfBirth) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender= gender;
		this.title = title;
		this.DateOfBirth = DateOfBirth;
	}
	public UserProfile(){
		
	}
	@Override
	public String toString() {
		return String.format("User{name='%s', title=%d}", name, title);
	}
	
	
	public void addAddressRouteTo(Address address) {
		userAddress.add(address);
	}
	
	public void addFacetRouteTo(Facet facet) {
		userFacet.add(facet);
	}
}
