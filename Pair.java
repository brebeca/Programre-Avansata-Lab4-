package com.company;

public class Pair {
    Resident resident;
    Hospital hospital;

    public Pair(Resident resident, Hospital h) {
        this.resident = resident;
        hospital=h;
    }

    public Resident getResident() {
        return resident;
    }

    public Hospital getHospital() {
        return hospital;
    }
}
