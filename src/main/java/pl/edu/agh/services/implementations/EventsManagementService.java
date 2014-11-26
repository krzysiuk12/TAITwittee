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
import java.util.Set;

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
    public void addNewEvent(Event event) {
        eventManagementRepository.saveOrUpdate(event);
    }

    @Override
    @Transactional
    public void addNewComment(Event event, Comment comment) {
//        List<Comment> comments = event.getComments();
//        comments.add(comment);
//        eventManagementRepository.saveOrUpdate(event);

//        TODO - saving comment to database
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
    @Transactional
    public List<Event> getAllEvents() {
        return eventManagementRepository.getAllEvents();
    }
}
