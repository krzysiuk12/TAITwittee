package pl.edu.agh.beans.events;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.domain.Event;
import pl.edu.agh.services.interfaces.IEventsManagementService;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@ManagedBean(name = "showEventsListBean")
@ViewScoped
public class ShowEventsListBean extends SpringBeanAutowiringSupport {

    @Autowired
    public IEventsManagementService eventsManagementService;

    @Transactional
    public List<Event> getAllEvents() {
        return eventsManagementService.getAllEvents();
    }
}
