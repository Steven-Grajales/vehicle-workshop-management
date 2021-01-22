package com.repair.car.services;


import com.repair.car.model.RepairCreateForm;
import java.util.List;


public interface RepairService {

    void repairCreate(RepairCreateForm repairCreateForm) throws Exception;

    RepairCreateForm findByRepairId(Long repairId);

    List<RepairCreateForm> repairSearch(String repairSearchText) ;

    List<RepairCreateForm> findAllRepairs();

    void repairEdit(RepairCreateForm repairCreateForm);

    void deleteById(Long repairId);


}
