package pl.edu.agh.beans.events;

import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.domain.Event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@ManagedBean(name = "showEventsListBean")
@ViewScoped
public class ShowEventsListBean {

    public String goToEventDescription(Event event) {
        return NavigationResults.SHOW_EVENT_DESCRIPTION_PAGE.getNavigation();
    }


}
