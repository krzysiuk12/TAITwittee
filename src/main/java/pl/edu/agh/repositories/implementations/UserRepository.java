package pl.edu.agh.repositories.implementations;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.agh.domain.User;
import pl.edu.agh.domain.UserAccount;
import pl.edu.agh.repositories.interfaces.IUserRepository;
import pl.edu.agh.repositories.interfaces.IUsersManagementRepository;

@Repository
public class UserRepository extends BaseHibernateRepository implements IUserRepository {

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User findByEmail(String email) {
        return new User();
    }

    @Override
    public void saveOrUpdate(Object entity) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }
}