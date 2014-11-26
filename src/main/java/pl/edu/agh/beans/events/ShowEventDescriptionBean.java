package pl.edu.agh.beans.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Event;
import pl.edu.agh.services.interfaces.IEventsManagementService;

import javax.faces.bean.ManagedBean;
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

    private Long eventID;

    @Transactional
    public Event getEvent() {
        return eventsManagementService.getEventById(eventID);
    }

    public String goToEventDescription() {
        FacesContext context = FacesContext.getCurrentInstance();
        eventID = new Long(context.getExternalContext().getRequestParameterMap().get("eventID"));
        return NavigationResults.SHOW_EVENT_DESCRIPTION_PAGE.getNavigation();
    }
}
