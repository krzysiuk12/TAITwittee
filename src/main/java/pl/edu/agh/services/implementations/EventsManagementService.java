package pl.edu.agh.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Comment;
import pl.edu.agh.domain.Event;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.domain.UserGroup;
import pl.edu.agh.repositories.interfaces.IEventManagementRepository;
import pl.edu.agh.services.interfaces.IEventsManagementService;
import pl.edu.agh.services.interfaces.IUsersManagementService;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Service
public class EventsManagementService implements IEventsManagementService {

    @Autowired
    private IEventManagementRepository eventManagementRepository;
    @Autowired
    private IUsersManagementService usersManagementService;

    @Autowired
    public EventsManagementService(IEventManagementRepository eventManagementRepository) {
        this.eventManagementRepository = eventManagementRepository;
    }

    @Override
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
        eventManagementRepository.saveOrUpdate(event);

        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }

    @Override
    public void addNewComment(Event event, Comment comment) {

    }

    @Override
    public Event getEventById(Long id) {
        return eventManagementRepository.getById(id);
    }

    @Override
    public void removeEvent(Event event) {
        eventManagementRepository.removeEvent(event);
    }

    @Override
    public List<Event> getAllCreatorEvents(UserAccount account) {
        return eventManagementRepository.getAllCreatorEvents(account);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventManagementRepository.getAllEvents();
    }
}
