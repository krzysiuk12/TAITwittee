package pl.edu.agh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.agh.beans.navigation.NavigationResults;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@Controller
public class MainMenuController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginAction() {
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

}
