package lv.javaguru.java2.web;

import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleRequest;
import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleResponse;
import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleService;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleRequest;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleResponse;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class VehicleController {

    @Autowired
    AddVehicleService addVehicleService;

    @Autowired
    GetVehicleService getVehicleService;

    @ResponseBody
    @PostMapping(value = "/vehicle")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {

        Vehicle car = new Vehicle();
        User user = new User();
        user.setId(vehicleDTO.getDriverId());

        car.setUser(user);
        car.setModel(vehicleDTO.getModel());
        car.setColor(vehicleDTO.getColor());
        car.setYear(vehicleDTO.getYear());//TODO fix nullpointer exception
        car.setRegNumber(vehicleDTO.getRegNumber());

        AddVehicleRequest request = new AddVehicleRequest(car);

        AddVehicleResponse response = addVehicleService.addVehicle(request);

        vehicleDTO.setId(response.getVehicleId());
        return ResponseEntity.ok(vehicleDTO);
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public VehicleDTO getVehicle(@PathVariable("id") Long vehicleId) {
        GetVehicleRequest request = new GetVehicleRequest(vehicleId);
        GetVehicleResponse response = getVehicleService.get(request);
        return response.getCar();
    }

}
