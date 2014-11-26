package pl.edu.agh.beans.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Event;
import pl.edu.agh.services.interfaces.IEventsManagementService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@ManagedBean(name = "showEventDescriptionBean")
@SessionScoped
public class ShowEventDescriptionBean extends SpringBeanAutowiringSupport {

    @Autowired
    public IEventsManagementService eventsManagementService;

    private Event event;

    public Event getEvent() {
        return event;
    }

    public String goToEventDescription() {
        FacesContext context = FacesContext.getCurrentInstance();
        String eventID = context.getExternalContext().getRequestParameterMap().get("eventID");
        event = eventsManagementService.getEventById(new Long(eventID));
        return NavigationResults.SHOW_EVENT_DESCRIPTION_PAGE.getNavigation();
    }

}
