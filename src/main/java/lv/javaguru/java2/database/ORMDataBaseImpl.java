package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ORMDataBaseImpl implements Database{

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Trip> getAllTrips(){
        return session()
                .createCriteria(Trip.class)
                .list();
    }

    @Override
    public void addTrip(Trip trip){
        session().save(trip);
    }

    @Override
    public void registerUser(User user){
        session().save(user);
    }

    @Override
    public Optional<User> getUserByLogin(String login){

        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    @Override
    public boolean checkUserExist(Long id){
        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return user.getId() != null;

    }
}
