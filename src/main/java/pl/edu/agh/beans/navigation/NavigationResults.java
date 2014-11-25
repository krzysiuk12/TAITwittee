package pl.edu.agh.beans.navigation;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
public enum NavigationResults {


    LOG_IN_PAGE("LogInPage"),
    ADD_NEW_EVENT_PAGE("AddNewEventPage"),
    EDIT_EVENT_PAGE("EditEventPage"),
    SHOW_EVENT_DESCRIPTION_PAGE("ShowEventDescriptionPage"),
    SHOW_EVENTS_LIST_PAGE("ShowEventsListPage"),
    ADD_NEW_COMMENT_PAGE("AddNewCommentPage");

    private String navigation;

    private NavigationResults(String navigation) {
        this.navigation = navigation;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }
}
