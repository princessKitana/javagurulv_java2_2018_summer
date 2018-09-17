package lv.javaguru.java2.buisnesslogic.vehicle.get;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
class GetVehicleServiceImpl implements GetVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public GetVehicleResponse get(GetVehicleRequest request) {
        Optional<Vehicle> carOpt = vehicleRepository.getVehicle(request.getVehicleId());
        if (carOpt.isPresent()) {
            Vehicle vehicle = carOpt.get();

            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setId(vehicle.getId());
            vehicleDTO.setDriverId(vehicle.getUser().getId());
            vehicleDTO.setModel(vehicle.getModel());
            vehicleDTO.setColor(vehicle.getColor());
            vehicleDTO.setYear(vehicle.getYear());
            vehicleDTO.setRegNumber(vehicle.getRegNumber());
            return new GetVehicleResponse(vehicleDTO);
        } else {
            ApplicationError error = new ApplicationError("id", "Not found");
            throw new ApplicationException(error);
        }
    }

}
