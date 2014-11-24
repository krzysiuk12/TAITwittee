package pl.edu.agh.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.repositories.interfaces.IUsersManagementRepository;
import pl.edu.agh.services.interfaces.IUsersManagementService;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Service
public class UsersManagementService implements IUsersManagementService {

    private IUsersManagementRepository usersManagementRepository;

    @Autowired
    public UsersManagementService(IUsersManagementRepository usersManagementRepository) {
        this.usersManagementRepository = usersManagementRepository;
    }

    @Override
    public void addNewUser(UserAccount account) {
        usersManagementRepository.saveOrUpdate(account);
    }

    @Override
    public UserAccount getUserAccountById(Long id) {
        return usersManagementRepository.getById(id);
    }

    @Override
    public UserAccount getUserAccountByLogin(String login) {
        return usersManagementRepository.getUserAccountByLogin(login);
    }
}
