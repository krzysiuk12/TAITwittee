package pl.edu.agh.beans.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.services.interfaces.IEventsManagementService;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Component
@Scope("request")
public class AddNewCommentBean {

    @Autowired
    private IEventsManagementService eventsManagementService;

    public IEventsManagementService getEventsManagementService() {
        return eventsManagementService;
    }

    public void setEventsManagementService(IEventsManagementService eventsManagementService) {
        this.eventsManagementService = eventsManagementService;
    }
}
