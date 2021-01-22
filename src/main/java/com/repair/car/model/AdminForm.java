package com.repair.car.model;


public class AdminForm {


        private String repairDate;

        private String repairTime;

        private String PlateNo;

        private String repairStatus;

        private String repairType;

        private String afm;

        private String lastname;



    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairTime() { return repairTime; }

    public void setRepairTime(String repairTime) { this.repairTime = repairTime; }

    public String getPlateNo() {
        return PlateNo;
    }

    public void setPlateNo(String plateNo) {
        PlateNo = plateNo;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) { this.repairStatus = repairStatus; }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}