package pl.edu.agh.beans.menus;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.beans.navigation.NavigationResults;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Component
@Scope("session")
public class MainMenuBean {

    public String logInAction(){
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

    public String showEventsAction(){
        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }

    public String addNewEventAction(){
        return NavigationResults.ADD_NEW_EVENT_PAGE.getNavigation();
    }

}
