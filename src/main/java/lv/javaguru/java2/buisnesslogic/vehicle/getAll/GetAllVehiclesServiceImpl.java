package lv.javaguru.java2.buisnesslogic.vehicle.getAll;

import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
class GetAllVehiclesServiceImpl implements GetAllVehiclesService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public GetAllVehiclesResponse get(GetAllVehiclesRequest request) {
        List<Vehicle> cars = vehicleRepository.getAllVehicles(request.getUserId());
        List<VehicleDTO> carsDTO = new ArrayList<>(  );

        cars.forEach( vehicle -> {
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setId( vehicle.getId() );
            vehicleDTO.setModel( vehicle.getModel() );
            vehicleDTO.setColor( vehicle.getColor() );
            vehicleDTO.setYear( vehicle.getYear() );
            vehicleDTO.setRegNumber( vehicle.getRegNumber() );
            carsDTO.add( vehicleDTO );
        }
        );

        return new GetAllVehiclesResponse(carsDTO);

    }

}
