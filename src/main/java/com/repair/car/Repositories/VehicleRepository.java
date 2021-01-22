
package com.repair.car.Repositories;

import com.repair.car.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findAll();

    Vehicle findByPlateNo(String plateNo);

    Vehicle findByVehicleId(Long vehicleId);

    List<Vehicle> findByPlateNoOrUser_afm(String plateNo,String afm);

    List<Vehicle> findByUser_UserId(Long userId);

    void deleteByVehicleId(Long vehicleId);

    Vehicle save(Vehicle vehicle);

   boolean existsByPlateNo(String plateNo);

}


