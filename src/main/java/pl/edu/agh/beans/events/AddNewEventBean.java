package pl.edu.agh.beans.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Event;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.domain.UserGroup;
import pl.edu.agh.services.interfaces.IEventsManagementService;
import pl.edu.agh.services.interfaces.IUsersManagementService;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Component(value = "addNewEventBean")
@Scope("request")
public class AddNewEventBean extends SpringBeanAutowiringSupport {

    private Event event;
    @Autowired
    public IEventsManagementService eventsManagementService;
    @Autowired
    public IUsersManagementService usersManagementService;

    public Event getEvent() {
        if(event == null) {
            event = new Event();
        }
        return event;
    }

    @Transactional
    public String addNewEvent(Event event) {
        if (event.getCreator() == null) {
            UserAccount user = new UserAccount("user", UserGroup.CREATOR);
            usersManagementService.addNewUser(user);
            event.setCreator(user);
        }
        if (event.getUrl() == null) {
            event.setUrl("ABCD");
        }
        eventsManagementService.addNewEvent(event);

        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
