package pl.edu.agh.services.interfaces;

import pl.edu.agh.domain.UserAccount;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
public interface IUsersManagementService {

    public void addNewUser(UserAccount account);

    public UserAccount getUserAccountById(Long id);

    public UserAccount getUserAccountByLogin(String login);

}
