package pl.edu.agh.beans.events;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.domain.Event;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Component(value = "addNewEventBean")
@Scope("request")
public class AddNewEventBean {

    private Event event;

    public Event getEvent() {
        if(event == null) {
            event = new Event();
        }
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
