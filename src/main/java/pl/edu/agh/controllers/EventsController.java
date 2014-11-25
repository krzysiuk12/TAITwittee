package pl.edu.agh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.agh.domain.Event;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.domain.UserGroup;
import pl.edu.agh.services.interfaces.IEventsManagementService;
import pl.edu.agh.services.interfaces.IUsersManagementService;

/**
 * Created by krzysztofczernek on 25/11/14.
 */
@Controller
@RequestMapping(value = "/events")
public class EventsController {

    @Autowired
    private IEventsManagementService eventsManagementService;
    @Autowired
    private IUsersManagementService usersManagementService;

    @RequestMapping(method = RequestMethod.GET)
    public String listEvents(ModelMap model) {
        model.addAttribute("events", eventsManagementService.getAllEvents());
        model.addAttribute("event", new Event());
        return "events";
    }

     @RequestMapping(method = RequestMethod.POST)
     public String addEvent(@ModelAttribute("event") Event event, BindingResult result) {

        UserAccount user = new UserAccount("user", UserGroup.CREATOR);
        usersManagementService.addNewUser(user);

        event.setCreator(user);
        event.setUrl("http://newurl");
        eventsManagementService.addNewEvent(event);

        return "redirect:/events";
    }

    @RequestMapping("/delete/{eventId}")
    public String deleteUser(@PathVariable("eventId") Long eventId) {
        eventsManagementService.removeEvent(eventsManagementService.getEventById(eventId));
        return "redirect:/events";
    }
}
