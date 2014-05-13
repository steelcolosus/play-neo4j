package controllers;

import neo4j.models.UserProfile;
import neo4j.models.World;
import neo4j.services.GalaxyService;
import neo4j.services.Neo4JServiceProvider;
import neo4j.services.UserService;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import neo4jplugin.Transactional;

import java.util.List;

/**
 * @author tuxburner
 */
public class ApplicationController extends Controller {

    @Transactional
    public static Result index() {

       /* final GalaxyService galaxyService = Neo4JServiceProvider.get().galaxyService;

        if (galaxyService.getNumberOfWorlds() == 0) {
            galaxyService.makeSomeWorldsAndRelations();
        }

        //List<World> allWorlds = galaxyService.getAllWorlds();
        //List<World> allWorlds = galaxyService.getByName("Venus");
        List<World> allWorlds = galaxyService.getByMoons(60);
        Logger.info("searching for venus");
        final World first = allWorlds.get(0);
        final World last = allWorlds.get(allWorlds.size() - 1);
        final List<World> pathFromFirstToLast = galaxyService.getWorldPath(first, last);*/

        
        
    	final UserService userService = Neo4JServiceProvider.get().userService;
        //List<UserProfile> profiles = userService.getAllUsers();
        long total = userService.getNumberOfUsers();
        
        return ok(views.html.index.render(total));
    }

}
