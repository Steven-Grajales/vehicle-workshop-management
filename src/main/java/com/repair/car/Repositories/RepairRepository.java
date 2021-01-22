package com.repair.car.Repositories;

import com.repair.car.domain.Repair;
import com.repair.car.domain.User;
import com.repair.car.model.RepairCreateForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {

    List<Repair> findAll();

    Repair findByRepairId(Long repairId);

    List<Repair> findByRepairDateOrVehicle_plateNo(String repairDate, String plateNo);

    List<Repair> findByVehicle_User_emailOrderByRepairDateDescRepairTimeAsc(String email);

    void deleteByRepairId(Long repairId);

    Repair save(Repair repair);

    @Query("SELECT r FROM Repair r WHERE " +
            "r.repairDate=?1 AND r.repairTime>=?2 " +"ORDER BY r.repairTime DESC")
    List<Repair> findRepairsOfDay  (String date, String time);

}
