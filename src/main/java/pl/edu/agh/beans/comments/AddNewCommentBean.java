package pl.edu.agh.beans.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
@ManagedBean(name = "addNewCommentBean")
@SessionScoped
public class AddNewCommentBean extends SpringBeanAutowiringSupport {

    @Autowired
    public IEventsManagementService eventsManagementService;
    @Autowired
    public IUsersManagementService usersManagementService;

    private Long eventID;

    public Long getEventID() {
        return eventID;
    }

    public String goToEventNewComment() {
        FacesContext context = FacesContext.getCurrentInstance();
        eventID = new Long(context.getExternalContext().getRequestParameterMap().get("eventID"));
        return NavigationResults.ADD_NEW_COMMENT_PAGE.getNavigation();
    }

    @Transactional
    public String addNewComment(Long eventId, Comment comment) {
        if (comment.getCommenter() == null) {
            UserAccount user = new UserAccount("commenter", UserGroup.COMMENTER);
            usersManagementService.addNewUser(user);
            comment.setCommenter(user);
        }
        if (comment.getRating() == null) {
            comment.setRating(Rating.VERY_GOOD);
        }

        Event event = eventsManagementService.getEventById(eventId);
        eventsManagementService.addNewComment(event, comment);

        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }
}
