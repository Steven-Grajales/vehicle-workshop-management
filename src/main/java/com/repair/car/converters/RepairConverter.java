package com.repair.car.converters;

import com.repair.car.domain.Repair;
import com.repair.car.model.RepairCreateForm;
import com.repair.car.utils.DateFormatConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RepairConverter {


    public static Repair buildRepairObject(RepairCreateForm repairForm){

        Repair repair = new Repair();

        repair.setRepairDate(DateFormatConverter.convert(repairForm.getRepairDate()));
        repair.setRepairTime(repairForm.getRepairTime());
        repair.setRepairStatus(repairForm.getRepairStatus());
        repair.setRepairType(repairForm.getRepairType());
        repair.setRepairDescription(repairForm.getRepairDescription());
        repair.setRepairCost(repairForm.getRepairCost());

        return repair;
    }


    public static RepairCreateForm buildRepairForm(Repair repair) {

        RepairCreateForm repairCreateForm = new RepairCreateForm();

        repairCreateForm.setRepairId(repair.getRepairId());
        repairCreateForm.setRepairDate(repair.getRepairDate());
        repairCreateForm.setRepairTime(repair.getRepairTime());
        repairCreateForm.setRepairStatus(repair.getRepairStatus());
        repairCreateForm.setRepairType(repair.getRepairType());
        repairCreateForm.setRepairCost(repair.getRepairCost());
        repairCreateForm.setRepairDescription(repair.getRepairDescription());
        repairCreateForm.setVehiclePlateNo(repair.getVehicle().getPlateNo());

        return repairCreateForm;
    }
   public static Repair buildUpdateRepairObject(RepairCreateForm repairCreateForm){

        Repair repair = new Repair();


        repair.setRepairId(repairCreateForm.getRepairId());
        repair.setRepairDate(DateFormatConverter.convert(repairCreateForm.getRepairDate()));
        repair.setRepairTime(repairCreateForm.getRepairTime());
        repair.setRepairStatus(repairCreateForm.getRepairStatus());
        repair.setRepairType(repairCreateForm.getRepairType());
        repair.setRepairDescription(repairCreateForm.getRepairDescription());
        repair.setRepairCost(repairCreateForm.getRepairCost());

        return repair;
    }
}
