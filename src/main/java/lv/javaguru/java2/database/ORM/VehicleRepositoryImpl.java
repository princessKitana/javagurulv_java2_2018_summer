package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleRepositoryImpl extends ORMRepository implements VehicleRepository {

    @Override
    public void addVehicle(Vehicle car){
            session().save(car);
        }

    @Override
    public Optional<Vehicle> getVehicle(Long id) {
        Vehicle car = (Vehicle) session().createCriteria(Vehicle.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(car);
    }

    @Override
    public Optional<Vehicle> checkVehicleBelongsToDriver(Long vehicleId, Long driverId) {

        User user = new User();
        user.setId( driverId );
        Vehicle car = (Vehicle) session().createCriteria(Vehicle.class)
                .add(Restrictions.eq("id", vehicleId))
                .add(Restrictions.eq("user", user))
                .uniqueResult();
        return Optional.ofNullable(car);
    }

    @Override
    public List<Vehicle> getAllVehicles(Long userId){
        User user = new User();
        user.setId( userId );
        List <Vehicle> cars = session().createCriteria(Vehicle.class)
                .add(Restrictions.eq("user", user))
                .list();

        return cars;
    }

}
