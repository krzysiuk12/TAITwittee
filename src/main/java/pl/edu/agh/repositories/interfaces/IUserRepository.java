package pl.edu.agh.repositories.interfaces;

import pl.edu.agh.domain.User;

public interface IUserRepository extends IBaseHibernateRepository<User> {

    public User findByEmail(String email);

}