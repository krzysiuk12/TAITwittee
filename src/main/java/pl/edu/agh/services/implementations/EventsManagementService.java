package pl.edu.agh.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.domain.Comment;
import pl.edu.agh.domain.Event;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.repositories.interfaces.IEventManagementRepository;
import pl.edu.agh.services.interfaces.IEventsManagementService;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Service
public class EventsManagementService implements IEventsManagementService {

    private IEventManagementRepository eventManagementRepository;

    @Autowired
    public EventsManagementService(IEventManagementRepository eventManagementRepository) {
        this.eventManagementRepository = eventManagementRepository;
    }

    @Override
    public void addNewEvent(Event event) {
        eventManagementRepository.saveOrUpdate(event);
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
