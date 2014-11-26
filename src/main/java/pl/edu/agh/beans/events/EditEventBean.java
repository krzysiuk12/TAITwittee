package pl.edu.agh.beans.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.*;
import pl.edu.agh.services.interfaces.IEventsManagementService;
import pl.edu.agh.services.interfaces.IUsersManagementService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@ManagedBean(name = "editEventBean")
@SessionScoped
public class EditEventBean extends SpringBeanAutowiringSupport {

    @Autowired
    public IEventsManagementService eventsManagementService;

    private Event event;

    @Transactional
    public Event getEvent() {
        return event;
    }

    @Transactional
    public void setEvent(Event event) {
        this.event = event;
    }

    public String goToEditEvent() {
        FacesContext context = FacesContext.getCurrentInstance();
        event = eventsManagementService.getEventById(new Long(context.getExternalContext().getRequestParameterMap().get("eventID")));
        return NavigationResults.EDIT_EVENT_PAGE.getNavigation();
    }

    @Transactional
    public String updateEvent() {
        eventsManagementService.updateEvent(this.event);
        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }

    @Transactional
    public String removeEvent() {
        FacesContext context = FacesContext.getCurrentInstance();
        Event eventToRemove = eventsManagementService.getEventById(new Long(context.getExternalContext().getRequestParameterMap().get("eventID")));
        eventsManagementService.removeEvent(eventToRemove);
        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }
}
