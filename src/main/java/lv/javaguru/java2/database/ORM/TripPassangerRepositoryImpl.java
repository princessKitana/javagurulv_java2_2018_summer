package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.TripPassangerRepository;
import lv.javaguru.java2.domain.TripPassanger;
import org.springframework.stereotype.Component;

@Component
public class TripPassangerRepositoryImpl extends ORMRepository implements TripPassangerRepository {

    public void addTripPassanger(TripPassanger tripPassanger){
        session().save(tripPassanger);
    }


}
