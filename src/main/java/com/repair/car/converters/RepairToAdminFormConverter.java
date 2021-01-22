package com.repair.car.converters;

import com.repair.car.domain.Repair;
import com.repair.car.model.AdminForm;

public class RepairToAdminFormConverter {

    public static AdminForm buildAdminForm(Repair repair) {

        AdminForm adminForm = new AdminForm();

        adminForm.setRepairDate(repair.getRepairDate());
        adminForm.setRepairTime(repair.getRepairTime());
        adminForm.setRepairType(repair.getRepairType());
        adminForm.setRepairStatus(repair.getRepairStatus());
        adminForm.setPlateNo(repair.getVehicle().getPlateNo());
        adminForm.setAfm(repair.getVehicle().getUser().getAfm());
        adminForm.setLastname(repair.getVehicle().getUser().getLastname());


        return adminForm;
    }

}
