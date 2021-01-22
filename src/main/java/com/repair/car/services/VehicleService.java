
package com.repair.car.services;


import com.repair.car.model.VehicleRegisterForm;

import java.util.List;


public interface VehicleService {


    void vehicleRegister(VehicleRegisterForm vehicleRegisterForm) throws Exception;

    VehicleRegisterForm findByVehicleId(Long vehicleId);

    List<VehicleRegisterForm> vehicleSearch(String SearchText);

    List<VehicleRegisterForm> findAllVehicles();

    void editVehicle(VehicleRegisterForm vehicleRegisterForm);

    void deleteById(Long vehicleId);

     boolean plateNoIsUnique(String plateNo);

    boolean userExists(String afm);

}




