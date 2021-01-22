package com.repair.car.services;
import com.repair.car.converters.VehicleConverter;
import com.repair.car.domain.User;
import com.repair.car.domain.Vehicle;
import com.repair.car.model.VehicleRegisterForm;
import com.repair.car.Repositories.UserRepository;
import com.repair.car.Repositories.VehicleRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(com.repair.car.services.VehicleServiceImpl.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void vehicleRegister(VehicleRegisterForm vehicleRegisterForm) throws Exception {

        Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleRegisterForm);
        User user = userRepository.findByAfm(vehicleRegisterForm.getAfm());
        vehicle.setUser(user);
        vehicleRepository.save(vehicle);
        LOG.debug("Vehicle has been registered!");

    }

    @Override
    public VehicleRegisterForm findByVehicleId(Long vehicleId) {

        return VehicleConverter.buildVehicleForm(vehicleRepository.findByVehicleId(vehicleId));

    }


    @Override
    public List<VehicleRegisterForm> findAllVehicles() {


        List<Vehicle> retrievedVehicles = vehicleRepository.findAll();

        return retrievedVehicles
                .stream()
                .map(VehicleConverter::buildVehicleForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRegisterForm> vehicleSearch(String searchText) {

//        Long userId = (userRepository.findByAfm(searchText)).getUserId();

        List<Vehicle> retrievedVehicles = vehicleRepository.findByPlateNoOrUser_afm(searchText, searchText);

        return retrievedVehicles
                .stream()
                .map(VehicleConverter::buildVehicleForm)
                .collect(Collectors.toList());
    }


    @Override
    public void editVehicle(VehicleRegisterForm vehicleToEdit) {

        Vehicle vehicle = VehicleConverter.buildUpdateVehicleObject(vehicleToEdit);
        Vehicle persistedVehicle = vehicleRepository.findByVehicleId(vehicle.getVehicleId());
        vehicle.setUser(persistedVehicle.getUser());
        vehicleRepository.save(vehicle);
        LOG.debug("Vehicle has been edited!");

    }

    @Override
    public void deleteById(Long vehicleId) {
        vehicleRepository.deleteByVehicleId(vehicleId);
    }


    @Override
    public boolean plateNoIsUnique(String plateNo) {

        return vehicleRepository.existsByPlateNo(plateNo);

    }

    @Override
    public boolean userExists(String afm) {

        return userRepository.existsByAfm(afm);

    }

}

