package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleRepositoryImpl extends ORMRepository implements VehicleRepository {

    @Override
    public void addVehicle(Vehicle car){
            session().save(car);
        }

}
