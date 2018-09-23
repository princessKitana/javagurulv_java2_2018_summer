package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl extends ORMRepository implements UserRepository {

    @Override
    public void registerUser(User user){
        session().save(user);
    }

    @Override
    public void setUserAsDriver(User user){

        User objectToUpdate = (User) session().get(User.class, user.getId());
        objectToUpdate.setDriver(true);
        session().update(objectToUpdate);
    }

    @Override
    public Optional<User> getUserByLogin(String login){

        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> checkUserExist(Long id){
        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return Optional.ofNullable(user);

    }

    @Override
    public Optional<User> getUserById(Long id){

        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(user);
    }
}
