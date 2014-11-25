package pl.edu.agh.beans.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.beans.navigation.NavigationResults;
import pl.edu.agh.services.interfaces.IUsersManagementService;

import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Component
@Scope("request")
public class LogInBean implements Serializable {

    @Autowired
    private IUsersManagementService usersManagementService;

    private String login;
    private String password;

    public String logInAction() {
        return NavigationResults.SHOW_EVENTS_LIST_PAGE.getNavigation();
    }

    //<editor-fold desc="Getters and Setters">
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUsersManagementService getUsersManagementService() {
        return usersManagementService;
    }

    public void setUsersManagementService(IUsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }
    //</editor-fold>
}
