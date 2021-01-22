
package com.repair.car.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "REPAIRS")

public class Repair implements Serializable {
    @Id
    @Column(name = "REPAIR_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairId;

    @Column(name = "REPAIR_DATE", nullable = false)
    private String repairDate;

    @Column(name = "REPAIR_TIME", nullable = false)
    private String repairTime;

    @Column(name = "REPAIR_STATUS")
    private String repairStatus;

    @Column(name = "REPAIR_TYPE")
    private String repairType;

    @Column(name = "REPAIR_COST")
    private String repairCost;

    @Column(name = "REPAIR_DESCRIPTION")
    private String repairDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "VEHICLE_ID")
    private Vehicle vehicle;

   // @OneToMany(mappedBy = "repair", targetEntity = Part.class , cascade=CascadeType.REMOVE)
   // private List<Part> parts;


    public Repair() { }

    public Repair(String date, String repairStatus, String repairType, String repairCost, String repairDescription, Long vehicleId) {
        this.repairDate = date;
        this.repairStatus = repairStatus;
        this.repairType = repairType;
        this.repairCost = repairCost;
        this.repairDescription = repairDescription;
    }

    public Vehicle getVehicle() { return vehicle; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Long getRepairId() { return repairId; }

    public void setRepairId(Long repairId) { this.repairId = repairId; }

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

//    public enum RepairStage {NOT_STARTED, IN_PROGRESS, COMPLETED};
//
//    public enum RepairType {SMALL, BIG};



    @Override
    public String toString() {
        return "Repair{" +
                "date='" + repairDate + '\'' +
                ", repairStatus='" + repairStatus + '\'' +
                ", repairType='" + repairType + '\'' +
                ", repairCost='" + repairCost + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                '}';
    }
}



