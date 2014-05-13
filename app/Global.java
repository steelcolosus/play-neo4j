import neo4j.services.Neo4JServiceProvider;
import neo4j.services.UserService;
import play.Application;
import play.GlobalSettings;
import play.Logger;


public class Global extends GlobalSettings{
	@Override
	public void onStart(Application app) {
		final UserService userService = Neo4JServiceProvider.get().userService;
        Logger.info("Getting service");
        
        if(userService.getNumberOfUsers()==0){
        	Logger.info("Generating users");
        	userService.generateUser();
        }
        Logger.info("Getting users");
	}
}
