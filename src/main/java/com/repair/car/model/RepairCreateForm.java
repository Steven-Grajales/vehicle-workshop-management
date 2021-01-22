package com.repair.car.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RepairCreateForm {

    private static final String REPAIR_TIME_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";;

    private static final String REPAIR_COST_PATTERN = "^[0-9]*$";

    private static final String VEHICLE_PLATENO_PATTERN = "^[A-Z]{3}-[0-9]{4}$";

    private static final int VEHICLE_PLATENO_SIZE = 8;

    private Long repairId;

    @NotEmpty(message = "{repairCreate.vehiclePlateNo.empty}")
    @Pattern(regexp = VEHICLE_PLATENO_PATTERN, message = "{repairCreate.vehiclePlateNo.invalid}")
    @Size(min = VEHICLE_PLATENO_SIZE, max = VEHICLE_PLATENO_SIZE, message = "{repairCreate.vehiclePlateNo.size}")
    private String vehiclePlateNo;

    @NotEmpty(message = "{repairCreate.repairDate.empty}")
    private String repairDate;

    @NotEmpty(message = "{repairCreate.repairTime.empty}")
    @Pattern(regexp = REPAIR_TIME_PATTERN, message = "{repairCreate.repairTime.invalid}")
    private String repairTime;

    private String repairStatus;

    private String repairType;

    @Pattern(regexp = REPAIR_COST_PATTERN, message = "{repairCreate.repairCost.invalid}")
    private String repairCost;

    private String repairDescription;

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }

    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairTime() { return repairTime; }

    public void setRepairTime(String repairTime) { this.repairTime = repairTime; }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(String repairCost) {
        this.repairCost = repairCost;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }
}
