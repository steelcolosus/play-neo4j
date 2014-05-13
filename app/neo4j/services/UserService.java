package neo4j.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import neo4j.models.Address;
import neo4j.models.Facet;
import neo4j.models.UserProfile;
import neo4j.models.World;
import neo4j.repositories.UserProfileRepository;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import play.Logger;
@Service
public class UserService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void generateUser() {
		List<UserProfile> userList = new ArrayList<UserProfile>();
		UserProfile user;
		for (int x = 0; x < 10000; x++) {
			
			user = new UserProfile("user" + x, "male" + x, "title"+ x, new Date().getTime());
			user.addAddressRouteTo(new Address("state" + x, "direction" + x,"city" + x));
			user.addAddressRouteTo(new Address("state" + (x + 1), "direction" + (x + 1), "city" + (x + 1)));
			user.addFacetRouteTo(new Facet("facet" + x));
				userList.add(user);

		}
		userProfileRepository.save(userList);
		
		for(int y = 0; y<(10000-30); y+=2){
			UserProfile us = userList.get(y);
			us.userFriends.add(userList.get(y+5));
			us.userFriends.add(userList.get(y+10));
			us.userFriends.add(userList.get(y+15));
			us.userFriends.add(userList.get(y+20));
			us.userFriends.add(userList.get(y+25));
			us.userFriends.add(userList.get(y+30));
			userProfileRepository.save(us);
		}
		
		
		
		Logger.info("finish");
		
	}
	
	
	public List<UserProfile> getAllUsers(){
		return new ArrayList<UserProfile>(IteratorUtil.asCollection(userProfileRepository.findAll()));
	}
	
	public long getNumberOfUsers(){
		return userProfileRepository.count();
	}
	

}
