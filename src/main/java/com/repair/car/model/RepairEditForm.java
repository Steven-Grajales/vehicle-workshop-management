package com.repair.car.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RepairEditForm {

    private static final String REPAIR_COST_PATTERN = "^[0-9]*$";

    private Long repairId;

    @NotEmpty(message = "{repairCreate.repairDate.empty}")
    private String repairDate;

    private String repairTime;

    private String repairStatus;

    private String repairType;

    @Pattern(regexp = REPAIR_COST_PATTERN, message = "{repairCreate.repairCost.invalid}")
    private String repairCost;

    private String repairDescription;

    public Long getRepairId() { return repairId; }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
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
